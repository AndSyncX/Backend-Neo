package com.idat.neo.domain.repository;

import com.idat.neo.domain.model.Assignment;

import java.util.List;
import java.util.Optional;

public interface AssignmentRepository {
    List<Assignment> findAll();
    Optional<Assignment> findById(Long id);
    Assignment save(Assignment assignment, Long scheduledCourseId);
    Assignment update(Long id, Assignment assignment, Long scheduledCourseId);
    void deleteById(Long id);
}
