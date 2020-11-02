package com.example.course7.repository;

import com.example.course7.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course/* ORM object*/, String /*primary key type*/> {
}
