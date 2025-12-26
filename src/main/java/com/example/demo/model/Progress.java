package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int progressPercent;
    private String status;
    private int score;

    @ManyToOne
    private User user;

    @ManyToOne
    private MicroLesson microLesson;
}
