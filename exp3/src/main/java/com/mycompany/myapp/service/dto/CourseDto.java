package com.mycompany.myapp.service.dto;

import lombok.Data;

///Data transfer object
//前端和后端交流的数据格式
@Data
public class CourseDto {
     private String courseName;
     private String courseLocation;
     private String courseContent;
     private Integer teacherId;

}
