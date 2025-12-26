package com.example.demo.service.impl;

import com.example.demo.model.MicroLesson;
import com.example.demo.model.Progress;
import com.example.demo.model.User;
import com.example.demo.repository.MicroLessonRepository;
import com.example.demo.repository.ProgressRepository;
import com.example.demo.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

public class ProgressServiceImpl {

    private final ProgressRepository progressRepo;
    private final UserRepository userRepo;
    private final MicroLessonRepository lessonRepo;

    public ProgressServiceImpl(ProgressRepository progressRepo,
                               UserRepository userRepo,
                               MicroLessonRepository lessonRepo) {
        this.progressRepo = progressRepo;
        this.userRepo = userRepo;
        this.lessonRepo = lessonRepo;
    }

    public Progress recordProgress(Long userId, Long lessonId, Progress incoming) {

        User user = userRepo.findById(userId).orElseThrow(RuntimeException::new);
        MicroLesson lesson = lessonRepo.findById(lessonId).orElseThrow(RuntimeException::new);

        Progress progress = progressRepo
                .findByUserIdAndMicroLessonId(userId, lessonId)
                .orElseGet(Progress::new);

        progress.setUser(user);
        progress.setMicroLesson(lesson);
        progress.setStatus(incoming.getStatus());
        progress.setProgressPercent(incoming.getProgressPercent());
        progress.setScore(incoming.getScore());
        progress.setLastAccessedAt(LocalDateTime.now());

        return progressRepo.save(progress);
    }

    public List<Progress> getUserProgress(Long userId) {
        return progressRepo.findByUserIdOrderByLastAccessedAtDesc(userId);
    }
}
