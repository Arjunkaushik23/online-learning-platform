package com.example.client;

import com.example.entity.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="COURSE-SERVICE")
public interface CourseClient {

    @GetMapping("/courses/users/{userId}")
    List<Course> getCourseByUserId(@PathVariable Long userId);
}
