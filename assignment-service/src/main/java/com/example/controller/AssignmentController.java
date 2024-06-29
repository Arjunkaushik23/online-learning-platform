package com.example.controller;

import com.example.entity.Assignment;
import com.example.service.AssignmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping
    public ResponseEntity<Assignment> createAssignment(@RequestBody Assignment assignment) {
        return ResponseEntity.ok(assignmentService.saveAssignment(assignment));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Assignment>> getAllAssignments() {
        return ResponseEntity.ok(assignmentService.getAllAssignments());
    }

    @GetMapping("/courses/{courseId}")
    public ResponseEntity<List<Assignment>> getAllAssignmentsByCourseId(@PathVariable Long courseId) {
        return ResponseEntity.ok(assignmentService.getAllAssignmentsByCourseId(courseId));
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Assignment>> getAllAssignmentsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(assignmentService.getAllAssignmentsByUserId(userId));
    }

    @GetMapping("/{assignmentId}")
    public ResponseEntity<Assignment> getByAssignmentId(@PathVariable Long assignmentId) {
        return ResponseEntity.ok(assignmentService.getByAssignmentId(assignmentId));
    }

    @GetMapping("/progress/{progressId}")
    public ResponseEntity<List<Assignment>> getByAssignmentByProgressId(@PathVariable Long progressId) {
        return ResponseEntity.ok(assignmentService.getByAssignmentByProgressId(progressId));
    }
}
