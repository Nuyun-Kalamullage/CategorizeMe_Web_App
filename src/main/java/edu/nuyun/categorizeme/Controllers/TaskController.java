package edu.nuyun.categorizeme.Controllers;

import edu.nuyun.categorizeme.Services.TaskService;
import edu.nuyun.categorizeme.models.Task;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 15/01/2024
 * @package edu.nuyun.categorizeme.Controllers
 * @project_Name CategorizeMe
 */
@CrossOrigin("http://localhost:3000") //to connect the React frontend
@RestController
@RequestMapping(path = "api/v1/task")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;
//    @Autowired
//    public TaskController(TaskService taskService) {
//        this.taskService = taskService;
//    }
    @GetMapping()
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

    @PostMapping()
    public ResponseEntity<String> addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }
}
