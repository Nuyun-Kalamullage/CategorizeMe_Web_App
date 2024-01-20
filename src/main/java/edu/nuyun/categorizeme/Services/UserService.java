package edu.nuyun.categorizeme.Services;

import edu.nuyun.categorizeme.PostgresDB.UserRepository;
import edu.nuyun.categorizeme.models.UserModel;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.util.List;
import java.util.Optional;

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

    public List<UserModel> getUsers(){
        return userRepository.findAll();
    }

    public void addNewUser(UserModel user) {
        Optional<UserModel> userModelOptional = userRepository.findUserModelByEmail(user.getEmail());
        userModelOptional.ifPresentOrElse((userModel)->{
            throw new IllegalArgumentException("Email Taken");
        },()->{
            userRepository.save(user);
        });
        System.out.println(user);
    }

    public void deleteCurrentUser(Long userId) {
        Optional<UserModel> userModelOptional = userRepository.findById(userId);
        userModelOptional.ifPresentOrElse(userRepository::delete,()->{
            throw new IllegalArgumentException("User Not Found! with user Id "+userId+".");
        });
    }


    @Transactional
    public void updateExistsUser(Long userId, String name, String email) {
        Optional<UserModel> userModelOptional = userRepository.findById(userId);
        userModelOptional.ifPresentOrElse(entity -> {
            if (name != null)
                if (!name.equals(entity.getName()) && !name.isEmpty()) {
                    entity.setName(name);
                }
            if (email != null)
                if (!email.equals(entity.getName()) && !email.isEmpty()) {
                    Optional<UserModel> user_modelOptional = userRepository.findUserModelByEmail(email);
                    user_modelOptional.ifPresentOrElse((userModel) -> {
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
