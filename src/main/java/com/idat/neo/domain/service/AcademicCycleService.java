package com.idat.neo.domain.service;

import com.idat.neo.domain.model.AcademicCycle;

import java.util.List;
import java.util.Optional;

public interface AcademicCycleService {
    List<AcademicCycle> findAll();
    AcademicCycle findById(Long id);
    AcademicCycle save(AcademicCycle academicCycle);
    AcademicCycle update(Long id, AcademicCycle academicCycle);
    void deleteById(Long id);
}
