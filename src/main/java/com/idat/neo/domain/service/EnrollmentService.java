package com.idat.neo.domain.service;

import com.idat.neo.domain.model.Enrollment;

import java.util.List;
import java.util.Optional;

public interface EnrollmentService {
    List<Enrollment> findAll();
    Enrollment findById(Long id);
    Enrollment save(Enrollment enrollment, Long userId, Long scheduledCourseId);
    Enrollment update(Long id, Enrollment enrollment, Long userId, Long scheduledCourseId);
    void deleteById(Long id);
}
