package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
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
