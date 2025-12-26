package com.example.demo.controller;

import com.example.demo.dto.RecommendationRequest;
import com.example.demo.model.Course;
import com.example.demo.service.impl.RecommendationServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
@RequiredArgsConstructor
@Tag(name = "5. Recommendations", description = "Personalized course recommendations")
public class RecommendationController {

    private final RecommendationServiceImpl recommendationService;

    @PostMapping
    @Operation(summary = "Get course recommendations for a user")
    public ResponseEntity<List<Course>> recommend(@RequestBody RecommendationRequest request) {
        return ResponseEntity.ok(
                recommendationService.getRecommendations(
                        request.getUserId(),
                        request.getCategory()
                )
        );
    }
}
