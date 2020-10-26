package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.User;
import com.mycompany.myapp.service.dto.StudentDTO;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public StudentDTO convertToStudent(User user) {
        return StudentDTO.builder()
            .id(user.getId())
            .firstName(user.getFirstName())
            .lastName(user.getLastName())
            .email(user.getEmail())
            .build();
    }
}
