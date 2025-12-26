package com.example.demo.service.impl;

import com.example.demo.model.MicroLesson;
import com.example.demo.model.Recommendation;
import com.example.demo.model.User;
import com.example.demo.repository.MicroLessonRepository;
import com.example.demo.repository.RecommendationRepository;
import com.example.demo.repository.UserRepository;

import java.util.List;

public class RecommendationServiceImpl {

    private final RecommendationRepository recommendationRepository;
    private final UserRepository userRepository;
    private final MicroLessonRepository microLessonRepository;

    public RecommendationServiceImpl(RecommendationRepository recommendationRepository,
                                     UserRepository userRepository,
                                     MicroLessonRepository microLessonRepository) {
        this.recommendationRepository = recommendationRepository;
        this.userRepository = userRepository;
        this.microLessonRepository = microLessonRepository;
    }

    public Recommendation getLatestRecommendation(Long userId) {
        List<Recommendation> list =
                recommendationRepository.findByUserIdOrderByGeneratedAtDesc(userId);

        if (list.isEmpty()) {
            throw new RuntimeException("No recommendation");
        }

        return list.get(0);
    }

    public Recommendation generateRecommendation(Long userId, List<Long> lessonIds) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        for (Long id : lessonIds) {
            microLessonRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Lesson not found"));
        }

        Recommendation r = new Recommendation();
        r.setRecommendedLessonIds(lessonIds.toString());

        return recommendationRepository.save(r);
    }
}
