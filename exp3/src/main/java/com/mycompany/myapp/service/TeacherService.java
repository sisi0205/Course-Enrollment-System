package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Course;
import com.mycompany.myapp.domain.User;
import com.mycompany.myapp.domain.UserCourse;
import com.mycompany.myapp.repository.CourseRepository;
import com.mycompany.myapp.repository.UserCourseRepository;
import com.mycompany.myapp.repository.UserRepository;
import com.mycompany.myapp.service.dto.CourseDto;
import com.mycompany.myapp.service.dto.StudentDTO;
import com.mycompany.myapp.service.mapper.CourseMapper;
import com.mycompany.myapp.service.mapper.StudentMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeacherService {

    private UserRepository userRepository;
    private CourseRepository courseRepository;
    private UserCourseRepository userCourseRepository;
    private CourseMapper courseMapper;
    private StudentMapper studentMapper;

    /**
     * Teacher add a course by CourseDto
     * 1. validate the user
     * 2. convert CourseDto to Course
     * 3. add course to "Course" table
     * @param courseDto
     */

    public CourseDto teacherAddCourse(CourseDto courseDto, String userName) {
        User user = userRepository.findOneByLogin(userName)
            .orElseThrow(() -> new UsernameNotFoundException("User name not found"));
        Course course = courseMapper.convertToCourse(courseDto, user);
        courseRepository.save(course);
//        Course courseUpdated = courseRepository.findOne(course);
        return courseDto;
    }

    /**
     * Teacher update a course by CourseDto
     * 1. validate the user
     * 2. convert CourseDto to Course
     * 3. update course to "Course" table
     * @param courseDto
     */
    public CourseDto teacherUpdateCourse(CourseDto courseDto, String userName) {
        User user = userRepository.findOneByLogin(userName)
            .orElseThrow(() -> new UsernameNotFoundException("User name not found"));
        Course oldCourse = courseRepository.findByTeacherIdAndCourseName(user.getId(),courseDto.getCourseName())
            .orElseThrow(() -> new IllegalArgumentException("Course name  or Teacher id is not valid"));
        Course newCourse = courseMapper.convertToCourseWithId(courseDto, oldCourse);
        courseRepository.saveAndFlush(newCourse);
        return courseMapper.convertToCourseDto(newCourse);
    }


    /**
     * Teacher delete a course by teacherId and courseName
     * 1. validate the user
     * 3. delete course to "Course" table by teacherId and courseName
     * @param courseDto
     */

    public void teacherDeleteCourse(CourseDto courseDto, String userName) {
        User user = userRepository.findOneByLogin(userName)
            .orElseThrow(() -> new UsernameNotFoundException("User name not found"));
        courseRepository.deleteByCourseNameAndTeacherId(courseDto.getCourseName(), user.getId());
    }

    /**
     * Teacher list all the course by teacherID
     * 1. validate the user
     * 2. get all the courses by teacherID
     * 3. convert data and return
     * @param userName
     * @return List<CourseDto>
     */

    public List<CourseDto> getTeacherCourse(String userName) {
        User user = userRepository.findOneByLogin(userName)
            .orElseThrow(() -> new UsernameNotFoundException("User name not found"));
        List<Course> courses = courseRepository.findByTeacherId(user.getId());
        return courses.stream()
            .map((course) -> courseMapper.convertToCourseDto(course))
            .collect(Collectors.toList());
    }

    /**
     * list all the students who enrolled his or her course
     * 1. validate the user
     * 2. get all the courses by teacherID
     * 3. convert data and return
     * @param userName
     * @return List<CourseDto>
     */

    public List<StudentDTO> getTeacherStudent(String userName) {
        User user = userRepository.findOneByLogin(userName)
            .orElseThrow(() -> new UsernameNotFoundException("User name not found"));
        List<Course> courses = courseRepository.findByTeacherId(user.getId());
        Set<UserCourse> userCourses = new HashSet<>();
        for (int i = 0; i < courses.size(); i++) {
            userCourses.addAll(userCourseRepository.findAllByCourse(courses.get(i)));
        }
        System.out.println(userCourses);

        return userCourses.stream()
            .map(userCourse -> userCourse.getUser())
            .map(student -> studentMapper.convertToStudent(student))
            .collect(Collectors.toList());
    }
}
