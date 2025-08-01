package com.idat.neo.domain.repository;

import com.idat.neo.domain.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {

    List<Course> findAll();

    List<Course> findActive();

    Optional<Course> findById(Long id);

    Optional<Course> findByName(String name);

    Course save(Course course);

    Course update(Long id, Course course);

    void deleteById(Long id);
}
