package com.example.service;

import com.example.entity.Progress;
import com.example.repository.ProgressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressService {

    private final ProgressRepository progressRepository;

    public ProgressService(ProgressRepository progressRepository) {
        this.progressRepository = progressRepository;
    }

    public Progress saveProgress(Progress progress) {
        return progressRepository.save(progress);
    }

    public List<Progress> getProgressByUserId(Long userId) {
        return progressRepository.findByUserId(userId);
    }

    public Progress getProgressByCourseId(Long courseId) {
        return progressRepository.findByCourseId(courseId);
    }

    public Progress getByProgressId(Long progressId) {
        return progressRepository.findById(progressId).orElseThrow();
    }

    public List<Progress> getAllProgress() {
        return progressRepository.findAll();
    }

    public void deleteProgress(Long progressId) {
        progressRepository.deleteById(progressId);
    }

    public Progress updateProgress(Long progressId, Progress progress) {

        Progress progress1 = progressRepository.findById(progressId).orElseThrow();
        progress1.setStatus(progress.getStatus());
        progress1.setCourseId(progress.getCourseId());
        progress1.setUserId(progress.getUserId());

        return progressRepository.save(progress1);

    }
}
