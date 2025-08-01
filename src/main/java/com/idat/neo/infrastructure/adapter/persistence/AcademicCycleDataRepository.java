package com.idat.neo.infrastructure.adapter.persistence;

import com.idat.neo.infrastructure.adapter.entity.AcademicCycleData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AcademicCycleDataRepository extends JpaRepository<AcademicCycleData, Long> {

    List<AcademicCycleData> findByActiveTrue();

    @Query("SELECT a FROM AcademicCycleData a WHERE LOWER(a.name) = LOWER(:name)")
    Optional<AcademicCycleData> findByNameIgnoreCase(@Param("name") String name);
}
