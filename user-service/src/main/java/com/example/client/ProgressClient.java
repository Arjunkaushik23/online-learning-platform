package com.example.client;

import com.example.entity.Progress;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "PROGRESS-SERVICE")
public interface ProgressClient {

    @GetMapping("/progress/users/{userId}")
    Progress getProgressById(@PathVariable Long userId);

    @PostMapping("/progress/")
    Progress createProgress(Progress progress);

    @PutMapping("/progress/{progressId}")
    Progress updateProgress(@PathVariable String progressId, Progress progress);

    @DeleteMapping("/progress/{progressId}")
    Progress deleteProgress(@PathVariable String progressId);

    @GetMapping("/progress/courses/{courseId}")
    Progress getProgressByCourseId(@PathVariable Long courseId);

}
