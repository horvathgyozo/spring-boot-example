package hello.service;

import hello.entity.Student;
import hello.repository.StudentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Iterable<Student> all() {
        return studentRepository.findAll();
    }
    
    public Student one(long id) {
        return studentRepository.findOne(id);
    }
    
    public List<Student> studentNamesStartingWith(String segment) {
        return studentRepository.findByFirstNameSegment(segment);
    }
    
    public Student save(Student student) {
        return studentRepository.save(student);
    }
    
    public Student update(long id, Student student) {
        student.setId(id);
        return studentRepository.save(student);
    }
    
    public void delete(long id) {
        studentRepository.delete(id);
    }
}
