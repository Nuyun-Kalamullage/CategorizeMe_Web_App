package edu.nuyun.categorizeme.Controllers;

import edu.nuyun.categorizeme.Services.UserService;
import edu.nuyun.categorizeme.models.DTO.UserDTO;
import edu.nuyun.categorizeme.models.DTO.UserDTOOld;
import edu.nuyun.categorizeme.models.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 19/01/2024
 * @package edu.nuyun.categorizeme.Controllers
 * @project_Name CategorizeMe
 */
@CrossOrigin("http://localhost:3000") //to connect the React frontend
@AllArgsConstructor
@RestController
@RequestMapping(path="api/v1/users")
public class UserController {

    private final UserService userService;
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getUsers();
    }
    @PostMapping
    public ResponseEntity<UserDTO> registerNewUser(@RequestBody User user){
        System.out.println(user);
        return new ResponseEntity<>(userService.addNewUser(user), HttpStatus.CREATED);
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
