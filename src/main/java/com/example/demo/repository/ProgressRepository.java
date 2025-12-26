package com.example.demo.repository;

import com.example.demo.entity.Progress;
import com.example.demo.entity.User;
import com.example.demo.entity.MicroLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {

    Optional<Progress> findByUserAndMicroLesson(User user, MicroLesson microLesson);

    List<Progress> findByUser(User user);
}