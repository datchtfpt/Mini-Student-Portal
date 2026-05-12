package fu.be.ministudentportal.repositories;

import fu.be.ministudentportal.dto.LessonDTO;
import fu.be.ministudentportal.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ILessonRepository extends JpaRepository<Lesson, Long> {

    public Optional<List<LessonDTO>> findByStudentId(Long studentId);
}
