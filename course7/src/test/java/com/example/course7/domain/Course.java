package com.example.course7.domain;

import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
@Data

public class Course {
    //// primary key
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;
}
