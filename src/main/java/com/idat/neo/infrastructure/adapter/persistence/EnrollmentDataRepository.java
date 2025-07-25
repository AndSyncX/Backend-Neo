package com.idat.neo.infrastructure.adapter.persistence;

import com.idat.neo.infrastructure.adapter.entity.EnrollmentData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentDataRepository extends JpaRepository<EnrollmentData, Long> {
}
