package com.example.course7.controller;

import com.example.course7.controller.dto.CourseDto;
import com.example.course7.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public List<CourseDto> getCourse() {
        /// under service
        return courseService.getCourses();
    }
}
