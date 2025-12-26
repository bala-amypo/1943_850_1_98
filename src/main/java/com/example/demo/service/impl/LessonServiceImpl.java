package com.example.demo.service.impl;

import com.example.demo.model.Course;
import com.example.demo.model.MicroLesson;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.MicroLessonRepository;

import java.util.List;

public class LessonServiceImpl {

    private final MicroLessonRepository microLessonRepository;
    private final CourseRepository courseRepository;

    public LessonServiceImpl(MicroLessonRepository microLessonRepository,
                             CourseRepository courseRepository) {
        this.microLessonRepository = microLessonRepository;
        this.courseRepository = courseRepository;
    }

    public MicroLesson addLesson(Long courseId, MicroLesson lesson) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        lesson.setCourse(course);
        return microLessonRepository.save(lesson);
    }

    public MicroLesson updateLesson(Long lessonId, MicroLesson update) {
        MicroLesson existing = microLessonRepository.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));

        existing.setTitle(update.getTitle());
        existing.setContentType(update.getContentType());
        existing.setDifficulty(update.getDifficulty());
        existing.setDurationMinutes(update.getDurationMinutes());
        existing.setTags(update.getTags());

        return microLessonRepository.save(existing);
    }

    public MicroLesson getLesson(Long id) {
        return microLessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));
    }

    public List<MicroLesson> findLessonsByFilters(String tag, String difficulty, String contentType) {
        return microLessonRepository.findByFilters(tag, difficulty, contentType);
    }
}
