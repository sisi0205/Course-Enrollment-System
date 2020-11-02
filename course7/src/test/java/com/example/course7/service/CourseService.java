package com.example.course7.service;

import com.example.course7.controller.dto.CourseDto;
import com.example.course7.domain.Course;
import com.example.course7.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseDto> getCourse() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(course -> CourseDto.builder()
                        .courseName(course.getName())
                        .build()
                )
                .collect(Collectors.toList());
    }
}
