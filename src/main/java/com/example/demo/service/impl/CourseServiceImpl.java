package com.example.demo.service.impl;

import com.example.demo.model.Course;
import com.example.demo.model.User;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.UserRepository;

public class CourseServiceImpl {
    private final CourseRepository repo;
    private final UserRepository users;

    public CourseServiceImpl(CourseRepository r,UserRepository u){
        repo=r; users=u;
    }

    public Course createCourse(Course c,Long instructorId){
        User u=users.findById(instructorId).orElseThrow();
        if(repo.existsByTitleAndInstructorId(c.getTitle(), instructorId))
            throw new RuntimeException();
        c.setInstructor(u);
        return repo.save(c);
    }

    public Course updateCourse(Long id,Course upd){
        Course c=repo.findById(id).orElseThrow();
        c.setTitle(upd.getTitle());
        return repo.save(c);
    }

    public Course getCourse(Long id){
        return repo.findById(id).orElseThrow();
    }
}
