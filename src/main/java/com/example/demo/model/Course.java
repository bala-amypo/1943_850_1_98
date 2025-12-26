package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;

    @ManyToOne
    private User instructor;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

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

    public User getInstructor() {
        return instructor;
    }

    public void setInstructor(User instructor) {
        this.instructor = instructor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /* ---------- Builder ---------- */
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Course c = new Course();

        public Builder id(Long id) {
            c.setId(id);
            return this;
        }

        public Builder title(String title) {
            c.setTitle(title);
            return this;
        }

        public Builder description(String description) {
            c.setDescription(description);
            return this;
        }

        public Builder instructor(User instructor) {
            c.setInstructor(instructor);
            return this;
        }

        public Course build() {
            return c;
        }
    }
}
