package fu.be.ministudentportal.services;

import fu.be.ministudentportal.dto.LessonDTO;
import fu.be.ministudentportal.entity.Lesson;

import java.util.List;

public interface ILessonService {

    public List<LessonDTO> getCompletedLessons(Long studentId);

    public Integer calculateTotalScore(Long studentId);

    public List<LessonDTO> getLessons(Long studentId);

    public LessonDTO createLesson(LessonDTO lessonDTO);
}
