package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Progress {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private MicroLesson microLesson;

    private String status;
    private Integer progressPercent;
    private LocalDateTime lastAccessedAt;
    private BigDecimal score;

    @PrePersist
    public void prePersist() {
        if (lastAccessedAt == null) lastAccessedAt = LocalDateTime.now();
    }
}
