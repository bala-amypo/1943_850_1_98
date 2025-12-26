package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;

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

    public Progress recordProgress(Long userId, Long lessonId, Progress input) {
        User user = userRepo.findById(userId)
                .orElseThrow(RuntimeException::new);
        MicroLesson lesson = lessonRepo.findById(lessonId)
                .orElseThrow(RuntimeException::new);

        Progress p = progressRepo
                .findByUserIdAndMicroLessonId(userId, lessonId)
                .orElse(new Progress());

        p.setUser(user);
        p.setMicroLesson(lesson);
        p.setStatus(input.getStatus());
        p.setProgressPercent(input.getProgressPercent());
        p.setScore(input.getScore());

        return progressRepo.save(p);
    }

    public List<Progress> getUserProgress(Long userId) {
        return progressRepo.findByUserIdOrderByLastAccessedAtDesc(userId);
    }
}
