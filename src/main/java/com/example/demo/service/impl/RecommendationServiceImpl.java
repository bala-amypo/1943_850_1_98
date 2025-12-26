package com.example.demo.service.impl;

import com.example.demo.model.Recommendation;
import com.example.demo.repository.RecommendationRepository;
import com.example.demo.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

public class RecommendationServiceImpl {

    private final RecommendationRepository repo;
    private final UserRepository userRepo;

    public RecommendationServiceImpl(RecommendationRepository repo,
                                     UserRepository userRepo,
                                     Object unused) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    public Recommendation getLatestRecommendation(Long userId) {
        List<Recommendation> list = repo.findByUserIdOrderByGeneratedAtDesc(userId);
        if (list.isEmpty()) throw new RuntimeException();
        return list.get(0);
    }
}
