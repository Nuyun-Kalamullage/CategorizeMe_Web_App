package edu.nuyun.categorizeme.Controllers;

import edu.nuyun.categorizeme.Services.UserService;
import edu.nuyun.categorizeme.models.UserModel;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public List<UserModel> getAllUsers() {
        return userService.getUsers();
    }
    @PostMapping
    public void registerNewUser(@RequestBody UserModel user){
        userService.addNewUser(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteCurrentUser(userId);
    }
    @PutMapping(path = "{userId}")
    public void updateUser(@PathVariable("userId") Long userId, @RequestParam(required = false) String name, @RequestParam(required = false) String email){
        userService.updateExistsUser(userId, name, email);
    }
}
