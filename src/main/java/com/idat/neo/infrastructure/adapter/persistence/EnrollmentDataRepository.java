package com.idat.neo.infrastructure.adapter.persistence;

import com.idat.neo.infrastructure.adapter.entity.EnrollmentData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EnrollmentDataRepository extends JpaRepository<EnrollmentData, Long> {

    @Query("SELECT e FROM EnrollmentData e WHERE LOWER(e.status) = LOWER(:status)")
    Optional<EnrollmentData> findByStatus(String status);
}
