package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Recommendation {

    @Id
    @GeneratedValue
    private Long id;

    private String recommendedLessonIds;
    private BigDecimal confidenceScore;
    private String basisSnapshot;
    private LocalDateTime generatedAt;

    @PrePersist
    public void prePersist() {
        this.generatedAt = LocalDateTime.now();
    }

    // -------- getters & setters --------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecommendedLessonIds() {
        return recommendedLessonIds;
    }

    public void setRecommendedLessonIds(String recommendedLessonIds) {
        this.recommendedLessonIds = recommendedLessonIds;
    }

    public BigDecimal getConfidenceScore() {
        return confidenceScore;
    }

    public void setConfidenceScore(BigDecimal confidenceScore) {
        this.confidenceScore = confidenceScore;
    }

    public String getBasisSnapshot() {
        return basisSnapshot;
    }

    public void setBasisSnapshot(String basisSnapshot) {
        this.basisSnapshot = basisSnapshot;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }

    /* ---------- Builder ---------- */
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Recommendation r = new Recommendation();

        public Builder id(Long id) {
            r.setId(id);
            return this;
        }

        public Builder recommendedLessonIds(String ids) {
            r.setRecommendedLessonIds(ids);
            return this;
        }

        public Builder confidenceScore(BigDecimal score) {
            r.setConfidenceScore(score);
            return this;
        }

        public Builder basisSnapshot(String snapshot) {
            r.setBasisSnapshot(snapshot);
            return this;
        }

        public Builder generatedAt(LocalDateTime time) {
            r.setGeneratedAt(time);
            return this;
        }

        public Recommendation build() {
            return r;
        }
    }
}
