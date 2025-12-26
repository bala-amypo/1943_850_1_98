package com.example.demo.model;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String category;
    private LocalDateTime createdAt;

    @ManyToOne
    private User instructor;

    @OneToMany(mappedBy = "course")
    private List<MicroLesson> lessons;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
