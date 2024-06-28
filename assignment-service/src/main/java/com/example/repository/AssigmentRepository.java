package com.example.repository;

import com.example.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssigmentRepository extends JpaRepository<Assignment, Long> {
}
