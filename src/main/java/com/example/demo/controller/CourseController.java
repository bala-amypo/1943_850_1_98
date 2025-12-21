package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@Tag(name = "Courses")
public class CourseController {

    private final CourseRepository repo;

    public CourseController(CourseRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Course create(@RequestBody Course course) {
        return repo.save(course);
    }

    @GetMapping
    public List<Course> getAll() {
        return repo.findAll();
    }
}
