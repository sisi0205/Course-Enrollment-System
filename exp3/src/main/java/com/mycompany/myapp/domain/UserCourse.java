package com.mycompany.myapp.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user_course")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCourse {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    ////add foreign key
    @JoinColumn(name = "user_id", referencedColumnName = "id" /* user table id*/)
    @ManyToOne /* many user to one course*/
    private User user;

    @JoinColumn(name = "course_id", referencedColumnName =  "id" /*course table id*/)
    @ManyToOne
    private Course course;
}
