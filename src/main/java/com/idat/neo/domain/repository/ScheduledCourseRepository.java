package com.idat.neo.domain.repository;

import com.idat.neo.domain.model.ScheduledCourse;

import java.util.List;
import java.util.Optional;

public interface ScheduledCourseRepository {

    List<ScheduledCourse> findAll();

    Optional<ScheduledCourse> findById(Long id);

    ScheduledCourse save(ScheduledCourse scheduledCourse, Long courseId, Long userId, Long academicCycleId);

    ScheduledCourse update(Long id, ScheduledCourse scheduledCourse, Long courseId, Long userId, Long academicCycleId);

    void deleteById(Long id);
}
