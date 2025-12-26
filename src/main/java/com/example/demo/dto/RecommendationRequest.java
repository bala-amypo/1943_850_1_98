package com.example.demo.dto;

public class RecommendationRequest {

    private Long userId;
    private String topic;
    private int limit;

    public RecommendationRequest() {
    }

    public RecommendationRequest(Long userId, String topic, int limit) {
        this.userId = userId;
        this.topic = topic;
        this.limit = limit;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
