package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MicroLesson {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String contentType;

    private String difficulty;

    private String tags;

    private Integer durationMinutes;

    @ManyToOne
    private Course course;
}