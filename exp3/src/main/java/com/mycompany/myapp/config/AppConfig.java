package com.mycompany.myapp.config;

import com.mycompany.myapp.service.mapper.CourseMapper;
import com.mycompany.myapp.utils.UserUtility;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    public UserUtility userTtility() {
        return new UserUtility();
    }

    @Bean
    public List<String> list() {
        return new ArrayList<>();
    }

//    @Bean
//    public CourseMapper courseMapper() {
//        return new CourseMapper();
//    }
}
