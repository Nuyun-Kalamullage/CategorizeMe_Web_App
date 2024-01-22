package edu.nuyun.categorizeme.Services;

import edu.nuyun.categorizeme.PostgresDB.RoleRepository;
import edu.nuyun.categorizeme.PostgresDB.UserRepository;
import edu.nuyun.categorizeme.models.DTO.UserDTO;
import edu.nuyun.categorizeme.models.Role;
import edu.nuyun.categorizeme.models.User;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 20/01/2024
 * @package edu.nuyun.categorizeme.Services
 * @project_Name CategorizeMe
 */
@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public UserDTO addNewUser(User user) {
        Optional<User> userModelOptional = userRepository.findUserByEmail(user.getEmail());
        userModelOptional.ifPresentOrElse((userModel)->{
            throw new IllegalArgumentException("Email Taken");
        },()->{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Role role = roleRepository.findByName("USER").orElse(null);
            user.setRoles(Collections.singletonList(role));
            userRepository.save(user);
        });
        return new UserDTO(user.getName(), user.getEmail());
    }

    public void deleteCurrentUser(Long userId) {
        Optional<User> userModelOptional = userRepository.findById(userId);
        userModelOptional.ifPresentOrElse(user->{
            user.setRoles(Collections.emptyList());
            userRepository.save(user);
            userRepository.delete(user);
        },()->{
            throw new IllegalArgumentException("User Not Found! with user Id "+userId+".");
        });
    }

    @Transactional
    public void updateExistsUser(Long userId, String name, String email) {
        Optional<User> userModelOptional = userRepository.findById(userId);
        userModelOptional.ifPresentOrElse(entity -> {
            if (name != null)
                if (!name.equals(entity.getName()) && !name.isEmpty()) {
                    entity.setName(name);
                }
            if (email != null)
                if (!email.equals(entity.getEmail()) && !email.isEmpty()) {
                    Optional<User> user_modelOptional = userRepository.findUserByEmail(email);
                    user_modelOptional.ifPresentOrElse((user) -> {
                        throw new IllegalArgumentException("Email Taken");
                    }, () -> {
                        entity.setEmail(email);
                    });
                }
            userRepository.save(entity);
        },()->{
            throw new IllegalArgumentException("User Not Found! with user Id "+userId+".");
        });
    }


}
