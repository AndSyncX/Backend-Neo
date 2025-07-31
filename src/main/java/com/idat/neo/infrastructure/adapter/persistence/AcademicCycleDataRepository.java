package com.idat.neo.infrastructure.adapter.persistence;

import com.idat.neo.infrastructure.adapter.entity.AcademicCycleData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AcademicCycleDataRepository extends JpaRepository<AcademicCycleData, Long> {

    Optional<AcademicCycleData> findByName(String name);

    List<AcademicCycleData> findByActiveTrue();
}
