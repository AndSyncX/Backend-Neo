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
@Table(schema = "neo", name = "material")
public class MaterialData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "scheduled_course_id")
    private ScheduledCourseData scheduledCourseData;

    @Column(name = "title", nullable = false, length = 250)
    private String title;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "upload_date", nullable = false)
    private LocalDate uploadDate;

    @Column(name = "file_url", nullable = false, length = 300)
    private String fileUrl;

    @Column(name = "firebase_file_url", nullable = false, length = 30)
    private String fileType;

    @Column(name = "is_required", nullable = false)
    private boolean isRequired;

    @Column(name = "active", nullable = false)
    private boolean active;
}
