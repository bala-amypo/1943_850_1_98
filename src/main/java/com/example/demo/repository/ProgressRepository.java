package com.example.demo.repository;

import com.example.demo.model.Progress;
import java.util.List;
import java.util.Optional;

public interface ProgressRepository {

    Optional<Progress> findByUserIdAndMicroLessonId(Long userId, Long microLessonId);

    List<Progress> findByUserIdOrderByLastAccessedAtDesc(Long userId);

    Progress save(Progress progress);
}
