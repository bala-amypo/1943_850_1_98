package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;

import java.util.List;

public class LessonServiceImpl {

    private final MicroLessonRepository lessonRepo;
    private final CourseRepository courseRepo;

    public LessonServiceImpl(MicroLessonRepository l, CourseRepository c) {
        this.lessonRepo = l;
        this.courseRepo = c;
    }

    public MicroLesson addLesson(Long courseId, MicroLesson lesson) {
        Course c = courseRepo.findById(courseId).orElseThrow(RuntimeException::new);
        lesson.setCourse(c);
        return lessonRepo.save(lesson);
    }

    public MicroLesson updateLesson(Long id, MicroLesson upd) {
        MicroLesson m = lessonRepo.findById(id).orElseThrow(RuntimeException::new);
        m.setTitle(upd.getTitle());
        m.setContentType(upd.getContentType());
        m.setDifficulty(upd.getDifficulty());
        return lessonRepo.save(m);
    }

    public List<MicroLesson> findLessonsByFilters(String t, String d, String c) {
        return lessonRepo.findByFilters(t, d, c);
    }

    public MicroLesson getLesson(Long id) {
        return lessonRepo.findById(id).orElseThrow(RuntimeException::new);
    }
}
