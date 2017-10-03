package hello;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!"; 
    }
    
    @RequestMapping("/get")
    public String getParameter(@RequestParam(required = false, defaultValue = "world", name = "nev") String name) {
        return "Hello " + name; 
    }
    
    @RequestMapping("/{name}")
    public String pathParameter(@PathVariable String name) {
        return "Hello " + name; 
    }

}