package com.example.demo.repository;

import com.example.demo.model.Course;
import java.util.Optional;

public interface CourseRepository {

    Optional<Course> findById(Long id);

    boolean existsByTitleAndInstructorId(String title, Long instructorId);

    Course save(Course course);
}
