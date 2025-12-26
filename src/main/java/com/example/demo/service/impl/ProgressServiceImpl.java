package com.example.demo.service.impl;

import com.example.demo.model.MicroLesson;
import com.example.demo.model.Progress;
import com.example.demo.model.User;
import com.example.demo.repository.MicroLessonRepository;
import com.example.demo.repository.ProgressRepository;
import com.example.demo.repository.UserRepository;

import java.util.List;

public class ProgressServiceImpl {

    private final ProgressRepository progressRepository;
    private final UserRepository userRepository;
    private final MicroLessonRepository microLessonRepository;

    public ProgressServiceImpl(ProgressRepository progressRepository,
                               UserRepository userRepository,
                               MicroLessonRepository microLessonRepository) {
        this.progressRepository = progressRepository;
        this.userRepository = userRepository;
        this.microLessonRepository = microLessonRepository;
    }

    public Progress recordProgress(Long userId, Long lessonId, Progress incoming) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        MicroLesson lesson = microLessonRepository.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));

        Progress progress = progressRepository
                .findByUserIdAndMicroLessonId(userId, lessonId)
                .orElse(new Progress());

        progress.setUser(user);
        progress.setMicroLesson(lesson);
        progress.setProgressPercent(incoming.getProgressPercent());
        progress.setStatus(incoming.getStatus());
        progress.setScore(incoming.getScore());

        return progressRepository.save(progress);
    }

    public List<Progress> getUserProgress(Long userId) {
        return progressRepository.findByUserIdOrderByLastAccessedAtDesc(userId);
    }
}
