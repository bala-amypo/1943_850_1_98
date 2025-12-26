package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;

import java.util.List;

public class ProgressServiceImpl {

    private final ProgressRepository repo;
    private final UserRepository userRepo;
    private final MicroLessonRepository lessonRepo;

    public ProgressServiceImpl(ProgressRepository r, UserRepository u, MicroLessonRepository l) {
        this.repo = r;
        this.userRepo = u;
        this.lessonRepo = l;
    }

    public Progress recordProgress(Long userId, Long lessonId, Progress incoming) {
        User u = userRepo.findById(userId).orElseThrow(RuntimeException::new);
        MicroLesson m = lessonRepo.findById(lessonId).orElseThrow(RuntimeException::new);

        Progress p = repo.findByUserIdAndMicroLessonId(userId, lessonId)
                .orElse(Progress.builder().user(u).microLesson(m).build());

        p.setStatus(incoming.getStatus());
        p.setProgressPercent(incoming.getProgressPercent());
        p.setScore(incoming.getScore());

        return repo.save(p);
    }

    public List<Progress> getUserProgress(Long userId) {
        return repo.findByUserIdOrderByLastAccessedAtDesc(userId);
    }
}
