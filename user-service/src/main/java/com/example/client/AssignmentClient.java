package com.example.client;

import com.example.entity.Assignment;
import jakarta.ws.rs.Path;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("ASSIGNMENT-SERVICE")
public interface AssignmentClient {

    @GetMapping("/assignments/courses/{courseId}")
    List<Assignment> getAssignmentByCourseId(@PathVariable Long courseId);

    @GetMapping("/assignments/users/{userId}")
    List<Assignment> getAssignmentByUserId(@PathVariable Long userId);
}

