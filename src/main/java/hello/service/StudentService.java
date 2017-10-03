package hello.service;

import hello.model.Student;
import hello.repository.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
       
    public List<Student> studentNamesStartingWith(String segment) {
        return studentRepository.findByFirstNameSegment(segment);
    }
    
    public Student save(Student student) {
        return studentRepository.save(student);
    }
}
