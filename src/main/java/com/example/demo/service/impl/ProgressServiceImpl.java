package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.ProgressRepository;
import org.springframework.stereotype.Service;

@Service
public class ProgressServiceImpl {

    private final ProgressRepository repository;

    public ProgressServiceImpl(ProgressRepository repository) {
        this.repository = repository;
    }

    public Progress saveProgress(User user, MicroLesson lesson, int percent) {

        Progress progress = new Progress();
        progress.setUser(user);
        progress.setMicroLesson(lesson);
        progress.setProgressPercent(percent);
        progress.setStatus("IN_PROGRESS");

        return repository.save(progress);
    }
}
