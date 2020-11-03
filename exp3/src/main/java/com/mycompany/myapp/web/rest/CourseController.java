package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.CourseService;
import com.mycompany.myapp.service.dto.CourseDto;
import com.mycompany.myapp.utils.UserUtility;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/// select course
/// controller is a bean
//@Controller
//@RequestBody
/// controller + requestBody
@RestController
//// add constructor
@AllArgsConstructor
///// use Securityconfig
@RequestMapping(path = "/api")
public class CourseController {
    private UserUtility userUtility;
    private CourseService courseService;
//    public CourseController(UserUtility userUtility) {
//        this.userUtility = userUtility;
//    }

    /// student enroll course
    ////http method
    /// POST : /course/enrollment
    /// Request body:  {courseName}
    /// Response body: null
    /// Header: user token  // use SecurityContextHolder.getContext().getAuthentication().getPrincipal()
    @PostMapping(path = "/course/enrollment")
    public void enrollCourse(@RequestBody CourseDto courseDto) {
        String courseName = courseDto.getCourseName();
//        String userName = getUserName();
        String userName = userUtility.getUserName();
        courseService.enrollCourse(courseName, userName);
    }

    /// list all the course
    /// GET : /course
    /// Request body:  null
    /// Response body: [course object] // courseDto
    /// Header: Need authorized
    @GetMapping(path = "/course")
    public List<CourseDto> getAllCourses() {
        return courseService.getAllCourses();
    }

    //// list enrolled course of student
    /// GET : /course/enrollment
    /// Request body:  null
    /// Response body: [course object] // courseDto
    /// Header: token
    @GetMapping(path = "/course/enrollment")
    public List<CourseDto> getEnrolledCourses() {
        String userName = userUtility.getUserName();
        return courseService.getEnrolledCourses(userName);
    }
    /// student drop the course
    /// DELETE : /course/enrollment/{courseName}
    /// Request body:  {courseName}
    /// Response body: null // courseDto
    /// Header: Need authorized
    @DeleteMapping(path = "/course/enrollment/{courseName}")
    public void dropCourse(@PathVariable String courseName) {
//        String courseName = courseDto.getCourseName();
//        String userName = getUserName();
        String userName = userUtility.getUserName();
        courseService.dropCourse(courseName, userName);
    }

}
