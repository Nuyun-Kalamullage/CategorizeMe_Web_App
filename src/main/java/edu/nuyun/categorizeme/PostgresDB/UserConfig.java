package edu.nuyun.categorizeme.PostgresDB;

import edu.nuyun.categorizeme.models.UserModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 20/01/2024
 * @package edu.nuyun.categorizeme.PostgresDB
 * @project_Name CategorizeMe
 */
@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository){
        return args -> {
            UserModel nuyun = new UserModel( "Nuyun", "nuyunpabasara@gmail.com");
            UserModel pabasara = new UserModel( "Pabasara", "nuyun457@gmail.com");
            userRepository.saveAll(
                    List.of(nuyun, pabasara));
        };
    }
}
