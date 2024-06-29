package com.example.service;


import com.example.client.AssignmentClient;
import com.example.client.CourseClient;
import com.example.client.ProgressClient;
import com.example.entity.Assignment;
import com.example.entity.Course;
import com.example.entity.Progress;
import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CourseClient courseClient;
    private final ProgressClient progressClient;
    private final AssignmentClient assignmentClient;

    public UserService(UserRepository userRepository, CourseClient courseClient,
                       ProgressClient progressClient, AssignmentClient assignmentClient) {
        this.userRepository = userRepository;
        this.courseClient = courseClient;
        this.progressClient = progressClient;
        this.assignmentClient = assignmentClient;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();

        List<Course> courses = courseClient.getCourseByUserId(userId);

        for (Course course : courses) {
            Progress progress = progressClient.getProgressByCourseId(course.getId());
            course.setProgress(progress);

            List<Assignment> assignments = assignmentClient.getAssignmentByCourseId(course.getId());
            course.setAssignments(assignments);
        }

        user.setCourses(courses);
        return user;

    }
}
