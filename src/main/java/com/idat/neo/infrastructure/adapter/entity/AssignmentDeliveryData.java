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
@Table(schema = "neo", name = "assignment_delivery")
public class AssignmentDeliveryData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "assignment_id", nullable = false)
    private AssignmentData assignmentData;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserData userData;

    @Column(name = "file", nullable = false, length = 80)
    private String file;

    @Column(name = "qualification")
    private Long qualification;

    @Column(name = "active", nullable = false)
    private boolean active;
}
