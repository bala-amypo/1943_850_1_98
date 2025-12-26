package com.example.demo.service.impl;

import com.example.demo.entity.Recommendation;
import com.example.demo.repository.RecommendationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RecommendationServiceImpl {

    private final RecommendationRepository repository;

    public RecommendationServiceImpl(RecommendationRepository repository) {
        this.repository = repository;
    }

    public Recommendation create(String content) {

        Recommendation r = new Recommendation();
        r.setContent(content);
        r.setGeneratedAt(LocalDateTime.now());

        return repository.save(r);
    }
}
