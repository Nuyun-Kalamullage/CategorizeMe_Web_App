package edu.nuyun.categorizeme.MongoDB;

import edu.nuyun.categorizeme.Services.TaskService;
import edu.nuyun.categorizeme.models.Category;
import edu.nuyun.categorizeme.models.Task;
import edu.nuyun.categorizeme.models.TaskPriority;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 21/01/2024
 * @package edu.nuyun.categorizeme.MongoDB
 * @project_Name CategorizeMe
 */
@Configuration
public class TaskConfig {
    @Bean
    CommandLineRunner taskCommandLineRunner(TaskRepository taskRepository){
        return args -> {
            Task task1 = new Task(
                    "The Assignment",
                    "Data Structures & Algorithms Assignment Due Date is Tomorrow",
                    Category.STUDY,
                    TaskPriority.VERY_IMPORTANT);
            Task task2 = new Task(
                    "Pay The Home Bills",
                    "Electricity, Water, and Phone bill Due Date is Next Week",
                    Category.HOME,
                    TaskPriority.IMPORTANT);
//            taskRepository.save(task2);
            taskRepository.findTaskByTitle(task1.title()).ifPresentOrElse(task->{
                System.out.println(task + " Already exists");
            },()->{
                System.out.println("Inserting Task " + task1);
                taskRepository.insert(task1);
            });
        };
    }
}
