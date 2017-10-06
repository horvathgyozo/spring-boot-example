package hello.controller;

import hello.entity.Student;
import hello.form.StudentForm;
import hello.service.StudentService;
import java.sql.SQLException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/student")
public class StudentController {

//    @Autowired
//    private StudentRepository studentRepository;
    @Autowired
    private StudentService studentService;

//    @ModelAttribute("student")
//    public Student addStudent() {
//        return new Student();
//    }
    @GetMapping("")
    public String studentList(Model model, @RequestParam(name = "message", required = false, defaultValue = "") String message, Student student) {
        model.addAttribute("title", "Student list");
//        model.addAttribute("students", studentService.studentNamesStartingWith(""));
        model.addAttribute("students", studentService.all());
        model.addAttribute("message", message);
        //model.addAttribute("student", new Student());
        return "list";
    }

    @GetMapping("/add")
    public String showAddForm(StudentForm studentForm) {
        return "add";
    }

//    @PostMapping
//    public String addStudent(Student student) {
//        studentService.save(student);
//        return "redirect:/student";
//    }
    @PostMapping("/add")
    public String addStudent(@Valid StudentForm studentForm, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
//            model.addAttribute("title", "Student list");
//            model.addAttribute("students", studentService.studentNamesStartingWith(""));
            return "add";
        }

        Student student = studentForm.toStudent();

        studentService.save(student);
        redirectAttributes.addAttribute("message", "Successfully added!");
        redirectAttributes.addFlashAttribute("student", student);
        return "redirect:/student";
    }

    @GetMapping("/edit/{id}")
    public String showAddForm(@PathVariable long id, StudentForm studentForm) {
        Student student = studentService.one(id);
        studentForm.fill(student);
        return "add";
    }

    @PostMapping("/edit/{id}")
    public String addStudent(@PathVariable long id, @Valid StudentForm studentForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "add";
        }

        Student student = studentForm.toStudent();

//        student.setId(id);
//        studentService.save(student);
        studentService.update(id, student);
        redirectAttributes.addAttribute("message", "Successfully updated!");
        redirectAttributes.addFlashAttribute("student", student);
        return "redirect:/student";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable long id, RedirectAttributes redirectAttributes) {
        studentService.delete(id);
        redirectAttributes.addAttribute("message", "Successfully deleted!");
        return "redirect:/student";
    }

    @ExceptionHandler({Exception.class})
    public String databaseError(Model model) {
        model.addAttribute("message", "Something went wrong");
        return "list";
    }
}
