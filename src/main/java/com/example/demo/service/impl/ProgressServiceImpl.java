package com.example.demo.service.impl;

import com.example.demo.model.MicroLesson;
import com.example.demo.model.Progress;
import com.example.demo.model.User;
import com.example.demo.repository.MicroLessonRepository;
import com.example.demo.repository.ProgressRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ProgressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressServiceImpl implements ProgressService {

    private final ProgressRepository progressRepository;
    private final UserRepository userRepository;
    private final MicroLessonRepository lessonRepository;

    public ProgressServiceImpl(ProgressRepository progressRepository,
                               UserRepository userRepository,
                               MicroLessonRepository lessonRepository) {
        this.progressRepository = progressRepository;
        this.userRepository = userRepository;
        this.lessonRepository = lessonRepository;
    }

    @Override
    public Progress recordProgress(Long userId, Long lessonId, Progress progress) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        MicroLesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));

        Progress existing = progressRepository
                .findByUserAndMicroLesson(user, lesson)
                .orElse(null);

        if (existing != null) {
            existing.setProgressPercent(progress.getProgressPercent());
            existing.setStatus(progress.getStatus());
            existing.setScore(progress.getScore());
            return progressRepository.save(existing);
        }

        progress.setUser(user);
        progress.setMicroLesson(lesson);

        if ("COMPLETED".equalsIgnoreCase(progress.getStatus())) {
            progress.setProgressPercent(100);
        }

        return progressRepository.save(progress);
    }

    @Override
    public List<Progress> getUserProgress(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return progressRepository.findByUser(user);
    }
}
