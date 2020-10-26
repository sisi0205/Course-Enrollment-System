package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findFirstByCourseName(String courseName);
    Optional<Course> findByTeacherIdAndCourseName(Long teacherId, String courseName);
    List<Course> findByTeacherId(Long id);

    @Transactional
    void deleteByCourseNameAndTeacherId(String courseName,Long id);
}
