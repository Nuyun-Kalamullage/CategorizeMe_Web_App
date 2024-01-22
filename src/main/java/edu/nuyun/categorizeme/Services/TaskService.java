package edu.nuyun.categorizeme.Services;

import edu.nuyun.categorizeme.MongoDB.TaskRepository;
import edu.nuyun.categorizeme.models.Task;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 15/01/2024
 * @package edu.nuyun.categorizeme.Services
 * @project_Name CategorizeMe
 */
@AllArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> getTasks(){
        return taskRepository.findAll();
    }
}
