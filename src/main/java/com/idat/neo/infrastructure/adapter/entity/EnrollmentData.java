package com.idat.neo.infrastructure.adapter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "db_neo", name = "enrollment")
public class EnrollmentData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseData courseData;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserData student;

    @Column(name = "enrollment_date")
    private LocalDate enrollmentDate;
}
