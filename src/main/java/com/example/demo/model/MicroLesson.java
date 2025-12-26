package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MicroLesson {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private Integer durationMinutes;
    private String contentType;
    private String difficulty;
    private String tags;

    @ManyToOne
    private Course course;
}
