package com.example.repository;

import com.example.entity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long>{
    List<Progress> findByUserId(Long userId);

    Progress findByCourseId(Long courseId);
}
