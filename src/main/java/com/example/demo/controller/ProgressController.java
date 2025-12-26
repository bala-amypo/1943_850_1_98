package com.example.demo.controller;

import com.example.demo.entity.Progress;
import com.example.demo.service.ProgressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/progress")
public class ProgressController {

    private final ProgressService progressService;

    public ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }

    @PostMapping("/{userId}/{lessonId}")
    public ResponseEntity<Progress> recordProgress(
            @PathVariable Long userId,
            @PathVariable Long lessonId,
            @RequestBody Progress progress) {

        return ResponseEntity.ok(
                progressService.recordProgress(userId, lessonId, progress)
        );
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Progress>> getUserProgress(
            @PathVariable Long userId) {

        return ResponseEntity.ok(progressService.getUserProgress(userId));
    }
}