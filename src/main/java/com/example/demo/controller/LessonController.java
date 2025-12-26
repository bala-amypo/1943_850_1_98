package com.example.demo.controller;

import com.example.demo.entity.MicroLesson;
import com.example.demo.service.LessonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lessons")
public class LessonController {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @PostMapping("/{courseId}")
    public ResponseEntity<MicroLesson> addLesson(
            @PathVariable Long courseId,
            @RequestBody MicroLesson lesson) {

        return ResponseEntity.ok(lessonService.addLesson(courseId, lesson));
    }

    @PutMapping("/{lessonId}")
    public ResponseEntity<MicroLesson> updateLesson(
            @PathVariable Long lessonId,
            @RequestBody MicroLesson lesson) {

        return ResponseEntity.ok(lessonService.updateLesson(lessonId, lesson));
    }

    @GetMapping("/{lessonId}")
    public ResponseEntity<MicroLesson> getLesson(@PathVariable Long lessonId) {
        return ResponseEntity.ok(lessonService.getLesson(lessonId));
    }

    @GetMapping
    public ResponseEntity<List<MicroLesson>> filterLessons(
            @RequestParam(required = false) String tag,
            @RequestParam(required = false) String difficulty,
            @RequestParam(required = false) String type) {

        return ResponseEntity.ok(
                lessonService.findLessonsByFilters(tag, difficulty, type)
        );
    }
}