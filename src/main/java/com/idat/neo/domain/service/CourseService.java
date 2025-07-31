package com.idat.neo.domain.service;

import com.idat.neo.domain.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> findAll();
    Course findById(Long id);
    Course save(Course course);
    Course update(Long id, Course course);
    void deleteById(Long id);
}
