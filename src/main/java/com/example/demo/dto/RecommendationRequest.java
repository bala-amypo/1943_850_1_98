package com.example.demo.dto;

import lombok.Data;

@Data
public class RecommendationRequest {
    private String difficulty;
    private String tags;
    private Integer maxItems;
}
