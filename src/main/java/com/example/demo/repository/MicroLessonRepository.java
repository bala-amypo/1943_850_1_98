package com.example.demo.repository;

import com.example.demo.model.MicroLesson;
import java.util.List;
import java.util.Optional;

public interface MicroLessonRepository {

    Optional<MicroLesson> findById(Long id);

    MicroLesson save(MicroLesson lesson);

    List<MicroLesson> findByFilters(String tag, String difficulty, String contentType);
}
