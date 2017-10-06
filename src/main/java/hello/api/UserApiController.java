package hello.api;

import hello.entity.User;
import hello.service.UserService;
import hello.service.exception.UserNotValidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<User> user() {
        if (userService.isLoggedIn()) {
            return ResponseEntity.ok(userService.getLoggedInUser());
        }
        return ResponseEntity.badRequest().build();
    }
    
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.register(user));
    }
    /**
    { 
        "username": "gyozke",
        "password": "a",
        "email": "gyozke@alma.hu"
    }
    */
    
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.login(user));
        }
        catch (UserNotValidException e) {
            return ResponseEntity.badRequest().build();
        }
//        User loginedUser = userService.login(user);
//        if (loginedUser != null)
//            return ResponseEntity.ok(loginedUser);
//        else
//            return ResponseEntity.badRequest().build();
    }
    
    @PostMapping("/login")
    public ResponseEntity<User> logout(@RequestBody User user) {
        userService.logout();
        return ResponseEntity.ok().build();
    }
}
