package fu.be.ministudentportal.repositories;

import fu.be.ministudentportal.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

    public Optional<Student> findByUsername(String username);

}
