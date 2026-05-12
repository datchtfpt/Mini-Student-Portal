package fu.be.ministudentportal.services;

import fu.be.ministudentportal.dto.ApiResponse;
import fu.be.ministudentportal.dto.LoginRequest;
import fu.be.ministudentportal.dto.RegisterRequest;
import fu.be.ministudentportal.dto.StudentDTO;
import fu.be.ministudentportal.entity.Student;
import fu.be.ministudentportal.exception.ResourceNotFoundException;
import fu.be.ministudentportal.repositories.IStudentRepository;
import fu.be.ministudentportal.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthService {

    @Autowired
    private IStudentRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    public String login(LoginRequest loginRequest) {
        Student user = repository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new ResourceNotFoundException("Username Not Found"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Wrong password");
        }

        return jwtUtils.generateToken(user.getUsername());
    }

    public StudentDTO register(@RequestBody RegisterRequest registerRequest) {
        Student student = new Student();
        student.setFullname(registerRequest.getFullName());
        student.setUsername(registerRequest.getUsername());
        student.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        student.setRole("student");

        return StudentDTO.toDTO(repository.save(student));
    }
}
