package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;

import java.util.List;

public class ProgressServiceImpl {

    private final ProgressRepository repo;
    private final UserRepository userRepo;
    private final MicroLessonRepository lessonRepo;

    public ProgressServiceImpl(ProgressRepository p, UserRepository u, MicroLessonRepository m) {
        this.repo = p; this.userRepo = u; this.lessonRepo = m;
    }

    public Progress recordProgress(Long userId, Long lessonId, Progress p) {
        User u = userRepo.findById(userId).orElseThrow(RuntimeException::new);
        MicroLesson m = lessonRepo.findById(lessonId).orElseThrow(RuntimeException::new);

        Progress existing = repo.findByUserIdAndMicroLessonId(userId, lessonId).orElse(null);
        if (existing == null) {
            p.setUser(u);
            p.setMicroLesson(m);
            return repo.save(p);
        }

        existing.setStatus(p.getStatus());
        existing.setProgressPercent(p.getProgressPercent());
        existing.setScore(p.getScore());
        return repo.save(existing);
    }

    public List<Progress> getUserProgress(Long userId) {
        return repo.findByUserIdOrderByLastAccessedAtDesc(userId);
    }
}
