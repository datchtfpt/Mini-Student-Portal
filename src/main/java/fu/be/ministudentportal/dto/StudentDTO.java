package fu.be.ministudentportal.dto;

import fu.be.ministudentportal.entity.Student;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StudentDTO {

    private Long id;

    @NotBlank
    private String username;

    private String fullname;

    private String role;

    public static StudentDTO toDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setUsername(student.getUsername());
        studentDTO.setFullname(student.getFullname());
        studentDTO.setRole(student.getRole());
        return studentDTO;
    }

}
