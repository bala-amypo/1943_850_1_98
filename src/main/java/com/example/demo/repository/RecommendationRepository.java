package com.example.demo.repository;

import com.example.demo.model.Recommendation;
import java.time.LocalDateTime;
import java.util.List;

public interface RecommendationRepository {

    List<Recommendation> findByUserIdOrderByGeneratedAtDesc(Long userId);

    List<Recommendation> findByUserIdAndGeneratedAtBetween(
            Long userId,
            LocalDateTime start,
            LocalDateTime end
    );

    Recommendation save(Recommendation recommendation);
}
