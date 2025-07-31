package com.idat.neo.domain.repository;

import com.idat.neo.domain.model.AcademicCycle;

import java.util.List;
import java.util.Optional;

public interface AcademicCycleRepository {

    List<AcademicCycle> findAll();

    Optional<AcademicCycle> findById(Long id);

    Optional<AcademicCycle> findByName(String name);

    List<AcademicCycle> findActive();

    AcademicCycle save(AcademicCycle academicCycle);

    AcademicCycle update(Long id, AcademicCycle academicCycle);

    void deleteById(Long id);
}
