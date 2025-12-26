package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Progress {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private MicroLesson microLesson;

    private Integer progressPercent;
    private String status;
    private BigDecimal score;
    private LocalDateTime lastAccessedAt;

    @PrePersist
    public void prePersist() {
        this.lastAccessedAt = LocalDateTime.now();
    }

    // -------- getters & setters --------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MicroLesson getMicroLesson() {
        return microLesson;
    }

    public void setMicroLesson(MicroLesson microLesson) {
        this.microLesson = microLesson;
    }

    public Integer getProgressPercent() {
        return progressPercent;
    }

    public void setProgressPercent(Integer progressPercent) {
        this.progressPercent = progressPercent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public LocalDateTime getLastAccessedAt() {
        return lastAccessedAt;
    }

    /* ---------- Builder ---------- */
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Progress p = new Progress();

        public Builder id(Long id) {
            p.setId(id);
            return this;
        }

        public Builder user(User user) {
            p.setUser(user);
            return this;
        }

        public Builder microLesson(MicroLesson microLesson) {
            p.setMicroLesson(microLesson);
            return this;
        }

        public Builder progressPercent(Integer percent) {
            p.setProgressPercent(percent);
            return this;
        }

        public Builder status(String status) {
            p.setStatus(status);
            return this;
        }

        public Builder score(BigDecimal score) {
            p.setScore(score);
            return this;
        }

        public Progress build() {
            return p;
        }
    }
}
