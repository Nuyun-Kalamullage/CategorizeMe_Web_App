package edu.nuyun.categorizeme.Controllers;

import edu.nuyun.categorizeme.Services.UserService;
import edu.nuyun.categorizeme.models.UserTable;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 19/01/2024
 * @package edu.nuyun.categorizeme.Controllers
 * @project_Name CategorizeMe
 */
@AllArgsConstructor
@RestController
@RequestMapping(path="api/v1/users")
public class UserController {

    private final UserService userService;
    @GetMapping
    public List<UserTable> getAllUsers(){
        return userService.getUsers();
    }

}
