package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired 
    private UserRepository userRepository;
    
    @GetMapping("/")
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }
    
}
