package edu.nuyun.categorizeme.PostgresDB;

import edu.nuyun.categorizeme.models.Role;
import edu.nuyun.categorizeme.models.User;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.List;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 20/01/2024
 * @package edu.nuyun.categorizeme.PostgresDB
 * @project_Name CategorizeMe
 */
@Configuration
@AllArgsConstructor
public class UserConfig {
    private final PasswordEncoder passwordEncoder ;
    @Bean
    CommandLineRunner userCommandLineRunner(UserRepository userRepository, RoleRepository roleRepository){
        return args -> {
            User nuyun = new User( "Nuyun", "nuyunpabasara@gmail.com", passwordEncoder.encode("nuyun123"));
            User pabasara = new User( "Pabasara", "nuyun457@gmail.com",  passwordEncoder.encode("pabasara"));
            Role user = new Role("USER");
            Role admin = new Role("ADMIN");
            nuyun.setRoles(List.of(user));
            pabasara.setRoles(Collections.singletonList(admin));
            userRepository.saveAll(
                    List.of(nuyun, pabasara));
        };
    }

}
