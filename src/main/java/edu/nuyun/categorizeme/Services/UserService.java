package edu.nuyun.categorizeme.Services;

import edu.nuyun.categorizeme.PostgresDB.UserRepository;
import edu.nuyun.categorizeme.models.UserTable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<UserTable> getUsers(){
        return userRepository.findAll();
    }
}
