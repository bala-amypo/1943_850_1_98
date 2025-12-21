package com.example.demo.controller;

import com.example.demo.model.Recommendation;
import com.example.demo.service.RecommendationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
@Tag(name = "Recommendation Controller")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    // POST /recommendations/generate/{userId}
    @PostMapping("/generate/{userId}")
    public Recommendation generateRecommendation(@PathVariable Long userId) {
        return recommendationService.generate(userId);
    }

    // GET /recommendations/latest/{userId}
    @GetMapping("/latest/{userId}")
    public Recommendation getLatestRecommendation(@PathVariable Long userId) {
        return recommendationService.getLatest(userId);
    }

    // GET /recommendations/user/{userId}
    @GetMapping("/user/{userId}")
    public List<Recommendation> getUserRecommendations(@PathVariable Long userId) {
        return recommendationService.getAll(userId);
    }
}
