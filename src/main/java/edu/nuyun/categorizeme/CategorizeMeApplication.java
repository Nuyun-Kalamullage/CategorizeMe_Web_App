package edu.nuyun.categorizeme;

import edu.nuyun.categorizeme.MongoDB.TaskRepository;
import edu.nuyun.categorizeme.models.Category;
import edu.nuyun.categorizeme.models.Task;
import edu.nuyun.categorizeme.models.TaskPriority;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 15/01/2024
 * @package edu.nuyun.categorizeme
 * @project_Name CategorizeMe
 */

//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@SpringBootApplication
public class CategorizeMeApplication {
    public static void main(String[] args) {
        SpringApplication.run(CategorizeMeApplication.class, args);
    }

}
