
package com.example.demo.repository;

import com.example.demo.entity.MicroLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MicroLessonRepository extends JpaRepository<MicroLesson, Long> {

    List<MicroLesson> findByFilters(String topic, String level, String format);
}