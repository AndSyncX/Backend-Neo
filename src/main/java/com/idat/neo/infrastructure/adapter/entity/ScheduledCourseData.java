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
@Table(schema = "neo", name = "scheduled_course")
public class ScheduledCourseData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    private CourseData courseData;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserData userData;

    @ManyToOne(optional = false)
    @JoinColumn(name = "academic_cycle_id", nullable = false)
    private AcademicCycleData academicCycleData;

    @Column(name = "modality", nullable = false, length = 50)
    private String modality;

    @Column(name = "classroom", nullable = false, length = 50)
    private String classroom;

    @Column(name = "schedule", nullable = false, length = 100)
    private String schedule;

    @Column(name = "group_name", nullable = false, length = 50)
    private String group;

    @Column(name = "max_capacity", nullable = false)
    private Integer maxCapacity;

    @Column(name = "active")
    private boolean active;
}
