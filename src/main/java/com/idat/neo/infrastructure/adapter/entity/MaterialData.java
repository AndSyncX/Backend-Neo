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
@Table(schema = "neo", name = "material")
public class MaterialData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseData courseData;

    @Column(name = "title", length = 250)
    private String title;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "firebase_file_url", length = 300)
    private String firebaseFileUrl;
}
