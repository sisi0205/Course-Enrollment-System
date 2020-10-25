package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.dto.CourseDto;
import com.mycompany.myapp.utils.UserUtility;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/// select course
/// controller is a bean
//@Controller
//@RequestBody
/// controller + requestBody
@RestController
public class CourseController {
    private UserUtility userUtility;
    public CourseController(UserUtility userUtility) {
        this.userUtility = userUtility;
    }
    /// select course
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
    }

    /// list all the course
    /// GET : /course
    /// Request body:  null
    /// Response body: [course object] // courseDto
    /// Header: Need authorized

    @GetMapping(path = "/course")
    public List<CourseDto> getAllCourses() {
        return null;
    }

    //// list enrollmented course
    /// GET : /course/enrollment
    /// Request body:  null
    /// Response body: [course object] // courseDto
    /// Header: token

    @GetMapping(path = "/course/enrollment")
    public List<CourseDto> getEnrolledCourses() {
        String userName = userUtility.getUserName();
        return null;
    }
    /// drop course
    /// DELETE : /course/enrollment
    /// Request body:  {courseName}
    /// Response body: null // courseDto
    /// Header: Need authorized
    @DeleteMapping(path = "/course/enrollment")
    public void dropCourse(@RequestBody CourseDto courseDto) {
        String courseName = courseDto.getCourseName();
//        String userName = getUserName();
        String userName = userUtility.getUserName();
    }

}