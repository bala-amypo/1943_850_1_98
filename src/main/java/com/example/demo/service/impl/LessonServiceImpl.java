package com.example.demo.service.impl;

import com.example.demo.model.Course;
import com.example.demo.model.MicroLesson;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.MicroLessonRepository;
import com.example.demo.service.LessonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    private final MicroLessonRepository lessonRepo;
    private final CourseRepository courseRepo;

    public LessonServiceImpl(MicroLessonRepository lessonRepo, CourseRepository courseRepo) {
        this.lessonRepo = lessonRepo;
        this.courseRepo = courseRepo;
    }

    @Override
    public MicroLesson addLesson(Long courseId, MicroLesson lesson) {
        Course course = courseRepo.findById(courseId).orElseThrow();
        lesson.setCourse(course);
        return lessonRepo.save(lesson);
    }

    @Override
    public MicroLesson updateLesson(Long lessonId, MicroLesson lesson) {
        MicroLesson existing = lessonRepo.findById(lessonId).orElseThrow();
        existing.setTitle(lesson.getTitle());
        existing.setDurationMinutes(lesson.getDurationMinutes());
        existing.setContentType(lesson.getContentType());
        existing.setDifficulty(lesson.getDifficulty());
        existing.setTags(lesson.getTags());
        return lessonRepo.save(existing);
    }

    @Override
    public List<MicroLesson> searchLessons(String tags, String difficulty, String contentType) {
        return lessonRepo.findByTagsContainingAndDifficultyContainingAndContentTypeContaining(
                tags == null ? "" : tags,
                difficulty == null ? "" : difficulty,
                contentType == null ? "" : contentType
        );
    }

    @Override
    public MicroLesson getLesson(Long lessonId) {
        return lessonRepo.findById(lessonId).orElseThrow();
    }
}
