package com.example.demo.repository;

import com.example.demo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
package com.example.demo.repository;

import com.example.demo.model.MicroLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MicroLessonRepository extends JpaRepository<MicroLesson, Long> {

    @Query("""
        SELECT l FROM MicroLesson l
        WHERE (:tag IS NULL OR l.tags LIKE %:tag%)
          AND (:difficulty IS NULL OR l.difficulty = :difficulty)
          AND (:type IS NULL OR l.contentType = :type)
    """)
    List<MicroLesson> findByFilters(
            @Param("tag") String tag,
            @Param("difficulty") String difficulty,
            @Param("type") String type
    );
}