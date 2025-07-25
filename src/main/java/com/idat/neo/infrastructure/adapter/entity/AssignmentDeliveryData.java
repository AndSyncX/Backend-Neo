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
@Table(schema = "db_neo", name = "assignment_delivery")
public class AssignmentDeliveryData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private TaskData taskData;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserData userData;

    @Column(name = "file")
    private String file;

    @Column(name = "qualification")
    private Long qualification;
}
