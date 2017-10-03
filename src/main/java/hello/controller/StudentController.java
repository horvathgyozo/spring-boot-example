package hello.controller;

import hello.model.Student;
import hello.service.StudentService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    
//    @Autowired
//    private StudentRepository studentRepository;
    
    @Autowired
    private StudentService studentService;
    
    @ModelAttribute("student")
    public Student addStudent() {
        return new Student();
    }
    
    @GetMapping("")
    public String studentList(Model model) {
        model.addAttribute("title", "Student list");
        model.addAttribute("students", studentService.studentNamesStartingWith(""));
        //model.addAttribute("student", new Student());
        return "list";
    }
    
    @PostMapping
    public String addStudent(@ModelAttribute Student student) {
        studentService.save(student);
        return "redirect:/student"
    }
    
}
