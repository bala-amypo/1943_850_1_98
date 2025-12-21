package com.example.demo.controller;

import com.example.demo.model.Recommendation;
import com.example.demo.service.RecommendationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
@Tag(name = "Recommendations")
public class RecommendationController {

    private final RecommendationService service;

    public RecommendationController(RecommendationService service) {
        this.service = service;
    }

    @PostMapping("/generate/{userId}")
    public Recommendation generate(@PathVariable Long userId) {
        return service.generate(userId);
    }

    @GetMapping("/latest/{userId}")
    public Recommendation latest(@PathVariable Long userId) {
        return service.getLatest(userId);
    }

    @GetMapping("/user/{userId}")
    public List<Recommendation> list(@PathVariable Long userId) {
        return service.getAll(userId);
    }
}
