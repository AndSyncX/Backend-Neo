package com.idat.neo.infrastructure.adapter.persistence;

import com.idat.neo.infrastructure.adapter.entity.AcademicCycleData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademicCycleDataRepository extends JpaRepository<AcademicCycleData, Long> {
}
