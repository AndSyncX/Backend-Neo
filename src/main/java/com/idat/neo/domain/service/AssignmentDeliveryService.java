package com.idat.neo.domain.service;

import com.idat.neo.domain.model.AssignmentDelivery;

import java.util.List;

public interface AssignmentDeliveryService {

    List<AssignmentDelivery> findAll();

    AssignmentDelivery findById(Long id);

    AssignmentDelivery save(AssignmentDelivery assignmentDelivery, Long assignmentId, Long userId);

    AssignmentDelivery update(Long id, AssignmentDelivery assignmentDelivery, Long assignmentId, Long userId);

    void deleteById(Long id);
}
