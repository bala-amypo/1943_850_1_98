package com.example.demo.service.impl;

import com.example.demo.model.Recommendation;
import com.example.demo.model.User;
import com.example.demo.repository.RecommendationRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final RecommendationRepository repo;
    private final UserRepository userRepo;

    public RecommendationServiceImpl(RecommendationRepository repo, UserRepository userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    @Override
    public Recommendation generate(Long userId) {
        User user = userRepo.findById(userId).orElseThrow();

        Recommendation rec = Recommendation.builder()
                .user(user)
                .recommendedLessonIds("1,2,3")
                .basisSnapshot("Based on recent activity")
                .confidenceScore(0.85)
                .build();

        return repo.save(rec);
    }

    @Override
    public Recommendation getLatest(Long userId) {
        return repo.findByUserIdOrderByGeneratedAtDesc(userId).get(0);
    }

    @Override
    public List<Recommendation> getAll(Long userId) {
        return repo.findByUserIdOrderByGeneratedAtDesc(userId);
    }
}
