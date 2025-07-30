package com.idat.neo.domain.repository;

import com.idat.neo.domain.model.Enrollment;

import java.util.List;
import java.util.Optional;

public interface EnrollmentRepository {
    List<Enrollment> findAll();
    Optional<Enrollment> findById(Long id);
    Enrollment save(Enrollment enrollment, Long courseId, Long userId);
    Enrollment update(Long id, Enrollment enrollment, Long courseId, Long userId);
}
