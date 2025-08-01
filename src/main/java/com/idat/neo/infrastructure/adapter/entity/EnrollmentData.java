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
@Table(schema = "neo", name = "enrollment")
public class EnrollmentData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserData userData;

    @ManyToOne(optional = false)
    @JoinColumn(name = "scheduled_course_id", nullable = false)
    private ScheduledCourseData scheduledCourseData;

    @Column(name = "enrollment_date", nullable = false)
    private LocalDate enrollmentDate;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name = "active", nullable = false)
    private boolean active;
}
