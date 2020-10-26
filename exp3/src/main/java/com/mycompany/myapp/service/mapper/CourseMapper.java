package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.Course;
import com.mycompany.myapp.domain.User;
import com.mycompany.myapp.service.dto.CourseDto;
import org.springframework.stereotype.Component;


@Component
public class CourseMapper {
    /**
     * Course Mapper convert Course to CourseDto
     */
    public CourseDto convertToCourseDto(Course course) {
        return CourseDto.builder()
            .courseContent(course.getCourseContent())
            .courseLocation(course.getCourseLocation())
            .courseName(course.getCourseName())
            .teacherId(course.getTeacherId().intValue())
            .build();
    }
    /**
     * Course Mapper CourseDto to Course without courseID
     * */

    public Course convertToCourse(CourseDto courseDto, User user) {
        return Course.builder()
            .courseName(courseDto.getCourseName())
            .courseContent(courseDto.getCourseContent())
            .courseLocation(courseDto.getCourseLocation())
            .teacherId(user.getId())
            .build();
    }

    /**
     * Course Mapper CourseDto to Course with courseId
     * */

    public Course convertToCourseWithId(CourseDto courseDto, Course course) {
        return Course.builder()
            .id(course.getId())
            .courseName(courseDto.getCourseName())
            .courseContent(courseDto.getCourseContent())
            .courseLocation(courseDto.getCourseLocation())
            .teacherId(course.getTeacherId())
            .build();
    }

}
