package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.CourseService;
import com.mycompany.myapp.service.TeacherService;
import com.mycompany.myapp.service.dto.CourseDto;
import com.mycompany.myapp.service.dto.StudentDTO;
import com.mycompany.myapp.utils.UserUtility;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TeacherController {

    private UserUtility userUtility;
    private CourseService courseService;
    private TeacherService teacherService;

    /// teacher add course
    /// POST : /teacher/course
    /// Request body : {courseDto, {"courseName", "courseLocation":
    //        "courseContent"} }
    /// Response body: CourseDto
    /// Header user Token
    @PostMapping(path = "/teacher/course")
    public CourseDto addCourse(@RequestBody CourseDto courseDto) {
        String userName = userUtility.getUserName();
        return teacherService.teacherAddCourse(courseDto, userName);
    }

    /// teacher update course
    /// Patch : /teacher/course
    /// Request body : {courseDto}
    /// Response body: CourseDto
    /// Header user Token
    @PatchMapping(path = "/teacher/course")
    public CourseDto updateCourse(@RequestBody CourseDto courseDto) {
        String userName = userUtility.getUserName();
        return teacherService.teacherUpdateCourse(courseDto, userName);
    }


    /// teacher delete course
    /// Delete : /teacher/course
    /// Request body : {courseName}
    /// Response body: null
    /// Header user Token
    @DeleteMapping(path = "/teacher/course")
    public void deleteCourse(@RequestBody CourseDto courseDto) {
        String userName = userUtility.getUserName();
        teacherService.teacherDeleteCourse(courseDto, userName);
    }

    /// get all the course by given teacher ID
    /// GET : /teacher/course
    /// Request body : null
    /// Response body: null
    /// Header user Token
    @GetMapping(path = "/teacher/course")
    public List<CourseDto> getTeacherCourse() {
        String userName = userUtility.getUserName();
        return teacherService.getTeacherCourse(userName);
    }

    /// list all the students who enrolled his or her course
    /// GET : /teacher/student
    /// Request body : null
    /// Response body: [sudentDTO]
    /// Header user Token
    @GetMapping(path = "teacher/student")
    public List<StudentDTO> getTeacherStudent() {
        String userName = userUtility.getUserName();
        return teacherService.getTeacherStudent(userName);
    }
}
