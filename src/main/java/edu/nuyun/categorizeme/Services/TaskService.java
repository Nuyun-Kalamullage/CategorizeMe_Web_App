package edu.nuyun.categorizeme.Services;

import edu.nuyun.categorizeme.models.Category;
import edu.nuyun.categorizeme.models.Task;
import edu.nuyun.categorizeme.models.TaskPriority;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 15/01/2024
 * @package edu.nuyun.categorizeme.Services
 * @project_Name CategorizeMe
 */

@Service
public class TaskService {
    public List<Task> getTasks(){
        return List.of(
                new Task(
                        "0094",
                        "Do The Assignment",
                        "Data Structures & Algorithms Assignment Due Date is Tomorrow",
                        Category.STUDY,
                        TaskPriority.VERY_IMPORTANT),
                new Task(
                        "8267",
                        "Pay The Home Bills",
                        "Electricity, Water, and Phone bill Due Date is Next Week",
                        Category.HOME,
                        TaskPriority.IMPORTANT)
        );
    }
}
