package com.idat.neo.domain.service;

import com.idat.neo.domain.model.Course;

import java.util.List;

public interface CourseService {

    List<Course> findAll();

    List<Course> findActive();

    Course findById(Long id);

    Course findByName(String name);

    Course save(Course course);

    Course update(Long id, Course course);

    void deleteById(Long id);
}
