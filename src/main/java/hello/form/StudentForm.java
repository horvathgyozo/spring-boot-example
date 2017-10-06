package hello.form;

import hello.entity.Student;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentForm {

    private long id;
    
    @NotBlank
    @Size(min = 2)
    private String firstname;
    
    @Pattern(regexp = "^$|^.{2,}$", message = "{Pattern.student.lastname}")
    private String lastname;
    
    @Size(min = 7, max = 7)
    private String neptun;    
    
    public Student toStudent() {
        return new Student(0, firstname, lastname, neptun);
    }

    public void fill(Student student) {
        id = student.getId();
        firstname = student.getFirstname();
        lastname = student.getLastname();
        neptun = student.getNeptun();
    }
}
