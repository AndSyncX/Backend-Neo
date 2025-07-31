package com.idat.neo.domain.repository;

import com.idat.neo.domain.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {
    List<Course> findAll();
    Optional<Course> findById(Long id);
    Course save(Course course);
    Course update(Long id, Course course);
    void deleteById(Long id);
}
