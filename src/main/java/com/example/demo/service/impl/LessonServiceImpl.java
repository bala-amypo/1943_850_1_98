package com.example.demo.service.impl;

import com.example.demo.model.MicroLesson;
import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.MicroLessonRepository;

import java.util.List;

public class LessonServiceImpl {

    private final MicroLessonRepository lessonRepo;
    private final CourseRepository courseRepo;

    public LessonServiceImpl(MicroLessonRepository lessonRepo, CourseRepository courseRepo) {
        this.lessonRepo = lessonRepo;
        this.courseRepo = courseRepo;
    }

    public MicroLesson addLesson(Long courseId, MicroLesson lesson) {
        Course course = courseRepo.findById(courseId)
                .orElseThrow(RuntimeException::new);
        lesson.setCourse(course);
        return lessonRepo.save(lesson);
    }

    public MicroLesson updateLesson(Long lessonId, MicroLesson updated) {
        MicroLesson existing = lessonRepo.findById(lessonId)
                .orElseThrow(RuntimeException::new);

        existing.setTitle(updated.getTitle());
        existing.setContentType(updated.getContentType());
        existing.setDifficulty(updated.getDifficulty());

        return lessonRepo.save(existing);
    }

    public List<MicroLesson> findLessonsByFilters(String tags, String difficulty, String contentType) {
        return lessonRepo.findByFilters(tags, difficulty, contentType);
    }

    public MicroLesson getLesson(Long id) {
        return lessonRepo.findById(id).orElseThrow(RuntimeException::new);
    }
}
