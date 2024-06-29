package com.example.service;

import com.example.entity.Assignment;
import com.example.repository.AssigmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {

    private final AssigmentRepository assignmentRepository;

    public AssignmentService(AssigmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    public Assignment saveAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    public List<Assignment> getAllAssignmentsByCourseId(Long courseId) {
        return assignmentRepository.findByCourseId(courseId);
    }

    public List<Assignment> getAllAssignmentsByUserId(Long userId) {
        return assignmentRepository.findByUserId(userId);
    }

    public Assignment getByAssignmentId(Long assignmentId) {
        return assignmentRepository.findById(assignmentId).orElseThrow();
    }

    public List<Assignment> getByAssignmentByProgressId(Long progressId) {
        return assignmentRepository.findByProgressId(progressId);
    }
}
