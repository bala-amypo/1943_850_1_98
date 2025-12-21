package com.example.demo.service.impl;

import com.example.demo.model.MicroLesson;
import com.example.demo.model.Progress;
import com.example.demo.model.User;
import com.example.demo.repository.MicroLessonRepository;
import com.example.demo.repository.ProgressRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ProgressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressServiceImpl implements ProgressService {

    private final ProgressRepository repo;
    private final UserRepository userRepo;
    private final MicroLessonRepository lessonRepo;

    public ProgressServiceImpl(ProgressRepository repo,
                               UserRepository userRepo,
                               MicroLessonRepository lessonRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
        this.lessonRepo = lessonRepo;
    }

    @Override
    public Progress recordProgress(Long userId, Long lessonId, Progress progress) {
        User user = userRepo.findById(userId).orElseThrow();
        MicroLesson lesson = lessonRepo.findById(lessonId).orElseThrow();

        progress.setUser(user);
        progress.setMicroLesson(lesson);

        return repo.save(progress);
    }

    @Override
    public Progress getProgress(Long userId, Long lessonId) {
        return repo.findByUserIdAndMicroLessonId(userId, lessonId).orElseThrow();
    }

    @Override
    public List<Progress> getUserProgress(Long userId) {
        return repo.findByUserIdOrderByLastAccessedAtDesc(userId);
    }
}
