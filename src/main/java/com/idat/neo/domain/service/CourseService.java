package com.idat.neo.domain.service;

import com.idat.neo.domain.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();
    Course findById(Long id);
    Course save(Course course, String userId);
    Course update(Long id, Course course, String userId);
}
