package com.idat.neo.domain.service;

import com.idat.neo.domain.model.ScheduledCourse;

import java.util.List;

public interface ScheduledCourseService {

    List<ScheduledCourse> findAll();

    ScheduledCourse findById(Long id);

    ScheduledCourse save(ScheduledCourse scheduledCourse, Long courseId, Long userId, Long academicCycleId);

    ScheduledCourse update(Long id, ScheduledCourse scheduledCourse, Long courseId, Long userId, Long academicCycleId);

    void deleteById(Long id);
}
