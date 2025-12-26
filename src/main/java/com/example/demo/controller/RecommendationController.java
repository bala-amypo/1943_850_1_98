package com.example.demo.controller;

import com.example.demo.model.Recommendation;
import com.example.demo.service.RecommendationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/{userId}/latest")
    public ResponseEntity<Recommendation> getLatestRecommendation(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                recommendationService.getLatestRecommendation(userId)
        );
    }
}