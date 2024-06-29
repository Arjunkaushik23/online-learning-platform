package com.example.repository;

import com.example.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssigmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findByCourseId(Long courseId);
    List<Assignment> findByUserId(Long userId);

    List<Assignment> findByProgressId(Long progressId);
}
