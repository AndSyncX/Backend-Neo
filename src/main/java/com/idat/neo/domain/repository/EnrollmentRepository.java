package com.idat.neo.domain.repository;

import com.idat.neo.domain.model.Enrollment;

import java.util.List;
import java.util.Optional;

public interface EnrollmentRepository {

    List<Enrollment> findAll();

    Optional<Enrollment> findById(Long id);

    Optional<Enrollment> findByStatus(String status);

    Enrollment save(Enrollment enrollment, Long userId, Long scheduledCourseId);

    Enrollment update(Long id, Enrollment enrollment, Long userId, Long scheduledCourseId);

    void deleteById(Long id);
}
