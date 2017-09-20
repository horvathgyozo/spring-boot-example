package hello.model;

import javax.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name="first_name", nullable=false, length=100)
    private String firstname;
    
    @Column(name="last_name", nullable=true, length=100)
    private String lastname;
    
    @Column(nullable=false, length=7, unique = true)
    private String neptun;
}
