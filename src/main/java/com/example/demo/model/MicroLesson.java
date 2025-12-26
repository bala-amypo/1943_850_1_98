package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class MicroLesson {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String contentType;
    private String difficulty;
    private Integer durationMinutes;
    private String tags;

    @ManyToOne
    private Course course;

    // -------- getters & setters --------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    /* ---------- Builder ---------- */
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final MicroLesson m = new MicroLesson();

        public Builder id(Long id) {
            m.setId(id);
            return this;
        }

        public Builder title(String title) {
            m.setTitle(title);
            return this;
        }

        public Builder contentType(String contentType) {
            m.setContentType(contentType);
            return this;
        }

        public Builder difficulty(String difficulty) {
            m.setDifficulty(difficulty);
            return this;
        }

        public Builder durationMinutes(Integer durationMinutes) {
            m.setDurationMinutes(durationMinutes);
            return this;
        }

        public Builder tags(String tags) {
            m.setTags(tags);
            return this;
        }

        public Builder course(Course course) {
            m.setCourse(course);
            return this;
        }

        public MicroLesson build() {
            return m;
        }
    }
}
