package com.idat.neo.infrastructure.adapter.persistence;

import com.idat.neo.infrastructure.adapter.entity.AssignmentDeliveryData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentDeliveryDataRepository extends JpaRepository<AssignmentDeliveryData, Long> {
}
