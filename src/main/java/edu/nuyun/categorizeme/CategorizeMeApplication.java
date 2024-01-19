package edu.nuyun.categorizeme;

import edu.nuyun.categorizeme.MongoDB.TaskRepository;
import edu.nuyun.categorizeme.models.Category;
import edu.nuyun.categorizeme.models.Task;
import edu.nuyun.categorizeme.models.TaskPriority;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 15/01/2024
 * @package edu.nuyun.categorizeme
 * @project_Name CategorizeMe
 */

@SpringBootApplication
public class CategorizeMeApplication {
    public static void main(String[] args) {
        SpringApplication.run(CategorizeMeApplication.class, args);
    }
    @Bean
    CommandLineRunner runner(TaskRepository taskRepository){
        return args -> {
            Task task1 = new Task(
                    "0094",
                    "Do The Assignment",
                    "Data Structures & Algorithms Assignment Due Date is Tomorrow",
                    Category.STUDY,
                    TaskPriority.VERY_IMPORTANT);
            Task task2 = new Task(
                    "8267",
                    "Pay The Home Bills",
                    "Electricity, Water, and Phone bill Due Date is Next Week",
                    Category.HOME,
                    TaskPriority.IMPORTANT);
            taskRepository.save(task2);
            taskRepository.findTaskByTitle(task1.title()).ifPresentOrElse(title->{
                System.out.println(title + " Already exists");
            },()->{
                System.out.println("Inserting Task " + task1);
                taskRepository.insert(task1);
            });
        };
    }
}
