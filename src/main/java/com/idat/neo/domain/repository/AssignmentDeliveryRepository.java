package com.idat.neo.domain.repository;

import com.idat.neo.domain.model.AssignmentDelivery;

import java.util.List;
import java.util.Optional;

public interface AssignmentDeliveryRepository {
    List<AssignmentDelivery> findAll();
    Optional<AssignmentDelivery> findById(Long id);
    AssignmentDelivery save(AssignmentDelivery assignmentDelivery);
    AssignmentDelivery update(Long id, AssignmentDelivery assignmentDelivery);
    void deleteById(Long id);
}
