package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;

public class CourseServiceImpl {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public CourseServiceImpl(CourseRepository c, UserRepository u) {
        this.courseRepository = c;
        this.userRepository = u;
    }

    public Course createCourse(Course course, Long instructorId) {
        User u = userRepository.findById(instructorId).orElseThrow(RuntimeException::new);
        if (!"INSTRUCTOR".equals(u.getRole()) && !"ADMIN".equals(u.getRole())) {
            throw new RuntimeException();
        }
        if (courseRepository.existsByTitleAndInstructorId(course.getTitle(), instructorId)) {
            throw new RuntimeException();
        }
        course.setInstructor(u);
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, Course update) {
        Course c = courseRepository.findById(id).orElseThrow(RuntimeException::new);
        c.setTitle(update.getTitle());
        c.setDescription(update.getDescription());
        return courseRepository.save(c);
    }

    public Course getCourse(Long id) {
        return courseRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
