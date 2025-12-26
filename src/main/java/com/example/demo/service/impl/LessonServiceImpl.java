package com.example.demo.service.impl;

import com.example.demo.model.Course;
import com.example.demo.model.MicroLesson;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.MicroLessonRepository;

import java.util.List;

public class LessonServiceImpl {

    private final MicroLessonRepository repo;
    private final CourseRepository courseRepo;

    public LessonServiceImpl(MicroLessonRepository r, CourseRepository c) {
        this.repo = r; this.courseRepo = c;
    }

    public MicroLesson addLesson(Long courseId, MicroLesson m) {
        Course c = courseRepo.findById(courseId).orElseThrow(RuntimeException::new);
        m.setCourse(c);
        return repo.save(m);
    }

    public MicroLesson updateLesson(Long id, MicroLesson upd) {
        MicroLesson m = repo.findById(id).orElseThrow(RuntimeException::new);
        m.setTitle(upd.getTitle());
        m.setDifficulty(upd.getDifficulty());
        m.setContentType(upd.getContentType());
        return repo.save(m);
    }

    public List<MicroLesson> findLessonsByFilters(String t, String d, String c) {
        return repo.findByFilters(t, d, c);
    }

    public MicroLesson getLesson(Long id) {
        return repo.findById(id).orElseThrow(RuntimeException::new);
    }
}
