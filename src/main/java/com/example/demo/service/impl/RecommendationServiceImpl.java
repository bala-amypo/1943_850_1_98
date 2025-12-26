package com.example.demo.service.impl;

import com.example.demo.model.Recommendation;
import com.example.demo.model.User;
import com.example.demo.repository.MicroLessonRepository;
import com.example.demo.repository.RecommendationRepository;
import com.example.demo.repository.UserRepository;

import java.util.List;

public class RecommendationServiceImpl {

    private final RecommendationRepository repo;
    private final UserRepository userRepo;
    private final MicroLessonRepository lessonRepo;

    public RecommendationServiceImpl(RecommendationRepository repo,
                                     UserRepository userRepo,
                                     MicroLessonRepository lessonRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
        this.lessonRepo = lessonRepo;
    }

    public Recommendation getLatestRecommendation(Long userId) {
        userRepo.findById(userId).orElseThrow(RuntimeException::new);

        List<Recommendation> list =
                repo.findByUserIdOrderByGeneratedAtDesc(userId);

        if (list.isEmpty()) {
            throw new RuntimeException();
        }

        return list.get(0);
    }
}
