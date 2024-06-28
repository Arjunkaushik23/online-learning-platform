package com.example.controller;


import com.example.entity.Progress;
import com.example.service.ProgressService;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/")
    public ResponseEntity<Progress> createProgress(@RequestBody Progress progress) {
        return ResponseEntity.ok(progressService.saveProgress(progress));
    }

    @GetMapping("/{progressId}")
    public ResponseEntity<Progress> getByProgressId(@PathVariable Long progressId) {
        return ResponseEntity.ok(progressService.getByProgressId(progressId));
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Progress>> getProgressByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(progressService.getProgressByUserId(userId));
    }

    @GetMapping("/courses/{courseId}")
    public ResponseEntity<Progress> getProgressByCourseIdUserId(@PathVariable Long courseId) {
        return ResponseEntity.ok(progressService.getProgressByCourseId(courseId));
    }

    @GetMapping("/")
    public ResponseEntity<List<Progress>> getAllProgress() {
        return ResponseEntity.ok(progressService.getAllProgress());
    }

    @DeleteMapping("/{progressId}")
    public void deleteProgress(@PathVariable Long progressId) {
        System.out.println("Progress Deleted Successfully");
    }

    @PutMapping("/progress/{progressId}")
    public ResponseEntity<Progress> updateProgress(@PathVariable Long progressId, Progress progress){
        Progress updatedProgress = progressService.updateProgress(progressId, progress);
        return new ResponseEntity<>(updatedProgress, HttpStatus.ACCEPTED);

    }
}
