package fu.be.ministudentportal.services;

import fu.be.ministudentportal.dto.LessonDTO;
import fu.be.ministudentportal.entity.Lesson;
import fu.be.ministudentportal.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fu.be.ministudentportal.repositories.ILessonRepository;

import java.util.List;

@Service
public class LessonServicelmpl implements ILessonService {

    @Autowired
    private ILessonRepository repository;


    @Override
    public List<LessonDTO> getCompletedLessons(Long studentId) {
        return repository.findAll()
                .stream()
                .filter(lesson -> lesson.getStudent().getId().equals(studentId))
                .filter(Lesson::isCompleted)
                .map(LessonDTO::toDTO)
                .toList();
    }

    @Override
    public Integer calculateTotalScore(Long studentId) {
        return repository.findAll()
                .stream()
                .filter(lesson -> lesson.getStudent().getId().equals(studentId))
                .mapToInt(Lesson::getScore)
                .sum();
    }

    @Override
    public List<LessonDTO> getLessons(Long studentId) {
        List<LessonDTO> lessons = repository.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson Not Found"));

        return lessons;
    }


    @Override
    public LessonDTO createLesson(LessonDTO lessonDTO) {
        Lesson lesson = new Lesson();
        lesson.setCompleted(lessonDTO.isCompleted());
        lesson.setScore(lessonDTO.getScore());
        lesson.setTitle(lessonDTO.getTitle());
        repository.save(lesson);

        return LessonDTO.toDTO(lesson);

    }
}
