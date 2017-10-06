package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.ScriptAssert;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotBlank
    @Size(min = 2)
    @Column(name="first_name", nullable=false, length=100)
    private String firstname;
    
//    @Size(min = 2)
//    @Length(min = 2)
    @Pattern(regexp = "^$|^.{2,}$", message = "{Pattern.student.lastname}")
    @Column(name="last_name", nullable=true, length=100)
    private String lastname;
    
    @Size(min = 7, max = 7)
    @Column(nullable=false, length=7, unique = true)
    private String neptun;
}
