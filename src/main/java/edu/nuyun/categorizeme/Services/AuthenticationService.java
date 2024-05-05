package edu.nuyun.categorizeme.Services;

import edu.nuyun.categorizeme.Exceptions.AppException;
import edu.nuyun.categorizeme.PostgresDB.UserRepository;
import edu.nuyun.categorizeme.models.DTO.LoginDTO;
import edu.nuyun.categorizeme.models.DTO.UserDTO;
import edu.nuyun.categorizeme.models.User;
import edu.nuyun.categorizeme.models.mappers.UserMapper;
import edu.nuyun.categorizeme.security.UserAuthProvider;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 05/05/2024
 * @package edu.nuyun.categorizeme.Services
 * @project_Name CategorizeMe
 */
@AllArgsConstructor
@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserDTO findUserByLogin(String issuerID) {
        User user = userRepository.findUserByEmail(issuerID).orElseThrow(()-> new AppException("Unknown User!", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }
    public UserDTO login(LoginDTO loginDTO){
        User user = userRepository.findUserByEmail(loginDTO.email())
                .orElseThrow(()-> new AppException("Unknown User!", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(loginDTO.password(), user.getPassword())){
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalid password!", HttpStatus.BAD_REQUEST);
    }
}
