package hello.controller;

import hello.entity.User;
import hello.service.UserService;
import hello.service.exception.UserNotValidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/list")
    public String listUsers(Model model, User user) {
        model.addAttribute("users", userService.findAll());
        //model.addAttribute("user", new User());
        return "list";
    }
    
    @PostMapping("/list")
    public String addUser(User user) {
        userService.register(user);
        return "redirect:/user/list";
//        return "list";
    }
    
    @GetMapping("/login")
    public String showLogin(User user) {
        return "login";
    }
    
    @PostMapping("/login")
    public String login(Model model, User user) {
        try {
            userService.login(user);
            return "redirect:/";
        }
        catch (UserNotValidException e) {
            model.addAttribute("error", true);
            return "login";
        }
//        if (userService.login(user)) {
//            return "redirect:/";
//        }
//        model.addAttribute("error", true);
//        return "login";
    }
}
