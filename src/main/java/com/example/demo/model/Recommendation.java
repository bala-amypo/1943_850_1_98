package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder   // ✅ REQUIRED
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private String recommendedLessonIds;
    private String basisSnapshot;
    private Double confidenceScore;
    private LocalDateTime generatedAt;

    @PrePersist
    void onGenerate() {
        generatedAt = LocalDateTime.now();
    }
}
