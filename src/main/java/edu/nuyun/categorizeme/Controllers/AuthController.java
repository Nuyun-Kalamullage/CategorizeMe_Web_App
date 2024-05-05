package edu.nuyun.categorizeme.Controllers;

import edu.nuyun.categorizeme.Services.AuthenticationService;
import edu.nuyun.categorizeme.Services.UserService;
import edu.nuyun.categorizeme.models.DTO.LoginDTO;
import edu.nuyun.categorizeme.models.DTO.UserDTO;
import edu.nuyun.categorizeme.models.DTO.UserDTOOld;
import edu.nuyun.categorizeme.models.User;
import edu.nuyun.categorizeme.security.UserAuthProvider;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 05/05/2024
 * @package edu.nuyun.categorizeme.Controllers
 * @project_Name CategorizeMe
 */
@CrossOrigin("http://localhost:3000") //to connect the React frontend
@AllArgsConstructor
@RestController
@RequestMapping(path="api/v1/auth")
public class AuthController {

    private final UserService userService;
    private final UserAuthProvider userAuthProvider;
    private final AuthenticationService authenticationService;
    @PostMapping("/login")
    public ResponseEntity<UserDTO> loginUser(@RequestBody LoginDTO loginUser){
        System.out.println(loginUser);
        UserDTO userDTO =  authenticationService.login(loginUser);
        userDTO.setToken(userAuthProvider.createToken(userDTO.getEmail()));
        System.out.println(userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);

    }
    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signupUser(@RequestBody User user){
        System.out.println(user);
        UserDTO userDTO =  userService.addNewUser(user);
        userDTO.setToken(userAuthProvider.createToken(userDTO.getId().toString()));
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }
}
