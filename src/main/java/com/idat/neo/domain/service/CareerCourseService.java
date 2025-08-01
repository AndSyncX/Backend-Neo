package com.idat.neo.domain.service;

import com.idat.neo.domain.model.CareerCourse;

import java.util.List;

public interface CareerCourseService {

    List<CareerCourse> findAll();

    CareerCourse findById(Long id);

    CareerCourse save(CareerCourse careerCourse, Long courseId, Long careerId);

    CareerCourse update(Long id, CareerCourse careerCourse, Long courseId, Long careerId);

    void deleteById(Long id);
}
