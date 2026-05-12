package fu.be.ministudentportal.controller;

import fu.be.ministudentportal.dto.ApiResponse;
import fu.be.ministudentportal.dto.LessonDTO;
import fu.be.ministudentportal.entity.Lesson;
import fu.be.ministudentportal.services.ILessonService;
import fu.be.ministudentportal.services.LessonServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lesson")
public class LessonController {

    @Autowired
    private ILessonService lessonService;

    @GetMapping("/lesson/{studentId}")
    public ResponseEntity<ApiResponse<List<LessonDTO>>> getLesson(@PathVariable("studentId") Long studentId) {


        List<LessonDTO> lessons =  lessonService.getLessons(studentId);
        if(lessons == null || lessons.isEmpty()) {
            throw new RuntimeException("No lessons found");
        }
        return ResponseEntity.ok(new ApiResponse<>("success", lessons));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<LessonDTO>> createLesson(@RequestBody LessonDTO lessonDTO) {
        LessonDTO created = lessonService.createLesson(lessonDTO);
        return ResponseEntity.ok(new ApiResponse<>("success", created));
    }
}
