package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Course;
import com.mycompany.myapp.domain.User;
import com.mycompany.myapp.domain.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface UserCourseRepository extends JpaRepository<UserCourse, Long> {

    Optional<UserCourse> findFirstByUserAndCourse(User user, Course course);
    List<UserCourse> findAllByUser(User user);
    List<UserCourse> findAllByCourse(Course course);
    /// 1. first select by userId
    /// 2. select by courseId
    /// 3. delete
    @Transactional
    void deleteByUserAndCourse(User user, Course course);
}
