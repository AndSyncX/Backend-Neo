package com.idat.neo.infrastructure.adapter.entity;

import com.idat.neo.domain.model.ScheduledCourse;
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
@Table(schema = "neo", name = "assignment")
public class AssignmentData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @JoinColumn(name = "scheduledCourse_id", nullable = false)
    private ScheduledCourse scheduledCourse;

    @Column(name = "title", length = 250)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;
}
