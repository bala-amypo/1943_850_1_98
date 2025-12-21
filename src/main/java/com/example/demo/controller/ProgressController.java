package com.example.demo.controller;

import com.example.demo.model.Progress;
import com.example.demo.service.ProgressService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/progress")
@Tag(name = "Progress Controller")
public class ProgressController {

    private final ProgressService progressService;

    public ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }

    // POST /progress/{userId}/{lessonId}
    @PostMapping("/{userId}/{lessonId}")
    public Progress recordProgress(@PathVariable Long userId,
                                   @PathVariable Long lessonId,
                                   @RequestBody Progress progress) {
        return progressService.recordProgress(userId, lessonId, progress);
    }

    // GET /progress/{userId}/{lessonId}
    @GetMapping("/{userId}/{lessonId}")
    public Progress getProgress(@PathVariable Long userId,
                                @PathVariable Long lessonId) {
        return progressService.getProgress(userId, lessonId);
    }

    // GET /progress/user/{userId}
    @GetMapping("/user/{userId}")
    public List<Progress> getUserProgress(@PathVariable Long userId) {
        return progressService.getUserProgress(userId);
    }
}
