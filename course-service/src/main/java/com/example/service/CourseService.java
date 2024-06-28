package com.example.service;

import com.example.entity.Course;
import com.example.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course saveCourse(Course course){
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public Course courseById(Long courseId) {
        return courseRepository.findById(courseId).orElseThrow();
    }

    public List<Course> courseByUserId(Long courseId) {
        return courseRepository.getCourseByUserId(courseId);
    }
}
