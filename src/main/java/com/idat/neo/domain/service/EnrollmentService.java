package com.idat.neo.domain.service;

import com.idat.neo.domain.model.Enrollment;

import java.util.List;

public interface EnrollmentService {
    List<Enrollment> findAll();
    Enrollment findById(Long id);
    Enrollment save(Enrollment enrollment, Long courseId, String userId);
    Enrollment update(Long id, Enrollment enrollment, Long courseId, String userId);
}
