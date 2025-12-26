package com.example.demo.service.impl;

import com.example.demo.model.Course;
import com.example.demo.model.MicroLesson;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.MicroLessonRepository;

import java.util.List;

public class LessonServiceImpl {

    private final MicroLessonRepository lessonRepo;
    private final CourseRepository courseRepo;

    public LessonServiceImpl(MicroLessonRepository lessonRepo,
                             CourseRepository courseRepo) {
        this.lessonRepo = lessonRepo;
        this.courseRepo = courseRepo;
    }

    public MicroLesson addLesson(Long courseId, MicroLesson lesson) {
        Course c = courseRepo.findById(courseId)
                .orElseThrow(RuntimeException::new);

        lesson.setCourse(c);
        return lessonRepo.save(lesson);
    }

    public MicroLesson updateLesson(Long id, MicroLesson update) {
        MicroLesson existing = lessonRepo.findById(id)
                .orElseThrow(RuntimeException::new);

        existing.setTitle(update.getTitle());
        existing.setContentType(update.getContentType());
        existing.setDifficulty(update.getDifficulty());

        return lessonRepo.save(existing);
    }

    public List<MicroLesson> findLessonsByFilters(String tags, String diff, String type) {
        return lessonRepo.findByFilters(tags, diff, type);
    }

    public MicroLesson getLesson(Long id) {
        return lessonRepo.findById(id)
                .orElseThrow(RuntimeException::new);
    }
}
