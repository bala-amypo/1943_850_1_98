package com.example.demo.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationRequest {
    private String difficulty;
    private String tags;
    private Integer maxItems;
}
