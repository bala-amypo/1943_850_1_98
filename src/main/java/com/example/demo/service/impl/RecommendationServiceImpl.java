package com.example.demo.service.impl;

import com.example.demo.model.Recommendation;
import com.example.demo.repository.*;
import java.util.List;

public class RecommendationServiceImpl {

    private final RecommendationRepository repo;
    private final UserRepository userRepo;

    public RecommendationServiceImpl(RecommendationRepository r, UserRepository u, Object ignore) {
        this.repo = r;
        this.userRepo = u;
    }

    public Recommendation getLatestRecommendation(Long userId) {
        List<Recommendation> list = repo.findByUserIdOrderByGeneratedAtDesc(userId);
        if (list.isEmpty()) throw new RuntimeException();
        return list.get(0);
    }
}
