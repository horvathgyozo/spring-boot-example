package hello.controller;

import hello.model.Student;
import hello.service.StudentService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    
//    @Autowired
//    private StudentRepository studentRepository;
    
    @Autowired
    private StudentService studentService;
    
    @GetMapping("")
    public String studentList(Model model) {
        model.addAttribute("title", "Student list");
        model.addAttribute("students", studentService.studentNamesStartingWith("John"));
        return "list";
    }
    
}
