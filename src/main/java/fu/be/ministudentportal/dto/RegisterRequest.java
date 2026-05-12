package fu.be.ministudentportal.dto;


import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String fullName;
    private String password;
}
