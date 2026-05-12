package fu.be.ministudentportal.controller;

import fu.be.ministudentportal.dto.ApiResponse;
import fu.be.ministudentportal.dto.LoginRequest;
import fu.be.ministudentportal.dto.RegisterRequest;
import fu.be.ministudentportal.dto.StudentDTO;
import fu.be.ministudentportal.entity.Student;
import fu.be.ministudentportal.repositories.IStudentRepository;
import fu.be.ministudentportal.services.AuthService;
import fu.be.ministudentportal.services.IStudentService;
import fu.be.ministudentportal.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> login(@RequestBody LoginRequest loginRequest) {
        String token = authService.login(loginRequest);

        return ResponseEntity.ok(new ApiResponse<>("Login Success", token));
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<StudentDTO>> register(@RequestBody RegisterRequest registerRequest) {
        StudentDTO studentDTO = authService.register(registerRequest);
        ApiResponse<StudentDTO> response = new ApiResponse<>("Register Success",  studentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
