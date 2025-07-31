package com.idat.neo.infrastructure.adapter.persistence;

import com.idat.neo.infrastructure.adapter.entity.AssignmentData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentDataRepository extends JpaRepository<AssignmentData, Long> {
}
