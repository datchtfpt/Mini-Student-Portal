package fu.be.ministudentportal.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String fullname;

    private String role;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Lesson> lessons;

}
