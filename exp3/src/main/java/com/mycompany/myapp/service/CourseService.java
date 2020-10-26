package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Course;
import com.mycompany.myapp.domain.User;
import com.mycompany.myapp.domain.UserCourse;
import com.mycompany.myapp.repository.CourseRepository;
import com.mycompany.myapp.repository.UserCourseRepository;
import com.mycompany.myapp.repository.UserRepository;
import com.mycompany.myapp.service.dto.CourseDto;
import com.mycompany.myapp.service.mapper.CourseMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourseService {
    private CourseRepository courseRepository;
    private UserRepository userRepository;
    private UserCourseRepository userCourseRepository;
    private CourseMapper courseMapper;

    /**
     *  Enroll course by courseName and userName
     *  1. check the existence of user and course, if not exist throw exception
     *  2. check the existence of user-course pair in DB, if exist throw exception
     *  3. save user-course pair
     * @param courseName
     * @param userName
     */
    public void enrollCourse(String courseName, String userName) {
        /// check the existence of user and course
        UserCourse userCourse = getUserCourse(courseName, userName);
        //// check the existence of user-course pair in DB
        userCourseRepository.findFirstByUserAndCourse(userCourse.getUser(), userCourse.getCourse())
            .ifPresent(existCourse -> {
                throw new IllegalArgumentException("Course already enrolled");
            });
        ///save
        userCourseRepository.save(userCourse);
    }


    /**
     * 1. Get all courses from 'course' table
     * 2. Convert from Course to CourseDto and return.
     * @return all course dtos retrieved from database
     */

    public List<CourseDto> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
            .map(course -> courseMapper.convertToCourseDto(course))
            .collect(Collectors.toList());
    }

    /**
     * 1. Get user from 'user' table by userName
     * 2. Get all enrolled courses from 'course' by user
     * 3. convert and return
     * @param userName
     * @return all enrolled courses of user
     */
    public List<CourseDto> getEnrolledCourses(String userName) {
        // 1. Get user from 'user' table by userName
        User user = userRepository.findOneByLogin(userName)
            .orElseThrow(() -> new UsernameNotFoundException("User name not found"));
        // 2. Get all enrolled courses from 'course' by user
        List<UserCourse> userCourses = userCourseRepository.findAllByUser(user);

        return userCourses.stream()
            .map(userCourse -> userCourse.getCourse())
            .map(course -> courseMapper.convertToCourseDto(course))
            .collect(Collectors.toList());
    }

    /**
     * Drop course by courseName and userName
     * 1. get userCourse by courseName and userName
     * 2. Delete userCourse by course and user
     * @param courseName
     * @param userName
     */
    public void dropCourse(String courseName, String userName) {
        /// get userCourse by courseName and userName
        UserCourse userCourse = getUserCourse(courseName, userName);
        //// hibernate is always delete by id
        userCourseRepository.deleteByUserAndCourse(userCourse.getUser(), userCourse.getCourse());
    }


    private UserCourse getUserCourse(String courseName, String userName) {
        User user = userRepository.findOneByLogin(userName)
            .orElseThrow(() -> new UsernameNotFoundException("User name not found"));
        Course course = courseRepository.findFirstByCourseName(courseName)
            .orElseThrow(() -> new IllegalArgumentException("Course name not valid"));
        return UserCourse.builder()
            .user(user)
            .course(course)
            .build();
    }
}
