package com.idat.neo.infrastructure.adapter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "neo", name = "career_course")
public class CareerCourseData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "career_id", nullable = false)
    private CareerData careerData;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    private CourseData courseData;

    @Column(name = "is_mandatory", nullable = false)
    private boolean isMandatory;

    @Column(name = "active", nullable = false)
    private boolean active;
}
