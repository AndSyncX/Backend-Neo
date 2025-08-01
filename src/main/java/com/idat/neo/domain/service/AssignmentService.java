package com.idat.neo.domain.service;

import com.idat.neo.domain.model.Assignment;

import java.util.List;

public interface AssignmentService {

    List<Assignment> findAll();

    Assignment findById(Long id);

    Assignment save(Assignment assignment, Long scheduledCourseId);

    Assignment update(Long id, Assignment assignment, Long scheduledCourseId);

    void deleteById(Long id);
}
