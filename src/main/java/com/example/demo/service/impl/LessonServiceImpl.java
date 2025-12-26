package com.example.demo.service.impl;

import com.example.demo.entity.Course;
import com.example.demo.entity.MicroLesson;
import com.example.demo.repository.MicroLessonRepository;
import org.springframework.stereotype.Service;

@Service
public class LessonServiceImpl {

    private final MicroLessonRepository repository;

    public LessonServiceImpl(MicroLessonRepository repository) {
        this.repository = repository;
    }

    public MicroLesson createLesson(String title, Course course) {

        MicroLesson lesson = new MicroLesson();
        lesson.setTitle(title);
        lesson.setCourse(course);

        return repository.save(lesson);
    }
}
