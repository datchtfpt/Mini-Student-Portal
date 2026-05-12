package fu.be.ministudentportal.dto;

import fu.be.ministudentportal.entity.Lesson;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class LessonDTO {

    private Long id;

    @NotNull
    private String title;

    private Integer score;

    private boolean isCompleted;

    private Long studentId;

    public static LessonDTO toDTO(Lesson lesson){
        LessonDTO dto = new LessonDTO();
        dto.setId(lesson.getId());
        dto.setTitle(lesson.getTitle());
        dto.setScore(lesson.getScore());
        dto.setCompleted(lesson.isCompleted());
        dto.setStudentId(lesson.getStudent().getId());
        return dto;
    }

}
