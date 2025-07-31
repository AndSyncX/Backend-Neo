package com.idat.neo.domain.repository;

import com.idat.neo.domain.model.AssignmentDelivery;

import java.util.List;
import java.util.Optional;

public interface AssignmentDeliveryRepository {
    List<AssignmentDelivery> findAll();
    Optional<AssignmentDelivery> findById(Long id);
    AssignmentDelivery save(AssignmentDelivery assignmentDelivery, Long assignmentId, Long userId);
    AssignmentDelivery update(Long id, AssignmentDelivery assignmentDelivery, Long assignmentId, Long userId);
    void deleteById(Long id);
}
