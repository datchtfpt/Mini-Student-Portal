package fu.be.ministudentportal.services;

import org.springframework.stereotype.Service;
import fu.be.ministudentportal.repositories.IStudentRepository;

@Service
public class StudentServicelmpl implements IStudentService{

    private IStudentRepository repo;
    @Override
    public Integer countStudents() {
        return (int) repo.findAll()
                .stream()
                .filter(student -> "ROLE_STUDENT".equalsIgnoreCase(student.getRole()))
                .count();
    }
}
