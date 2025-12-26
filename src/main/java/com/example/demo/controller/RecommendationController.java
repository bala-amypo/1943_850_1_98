package com.example.demo.dto;

public class RecommendationRequest {

    private Long userId;
    private String category;

    public RecommendationRequest() {
    }

    public RecommendationRequest(Long userId, String category) {
        this.userId = userId;
        this.category = category;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
