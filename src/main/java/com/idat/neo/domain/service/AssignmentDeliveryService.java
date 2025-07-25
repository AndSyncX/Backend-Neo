package com.idat.neo.domain.service;

import com.idat.neo.domain.model.AssignmentDelivery;

import java.util.List;

public interface AssignmentDeliveryService {
    List<AssignmentDelivery> findAll();
    AssignmentDelivery findById(Long id);
    AssignmentDelivery save(AssignmentDelivery assignmentDelivery, Long taskId, String userId);
    AssignmentDelivery update(Long id, AssignmentDelivery assignmentDelivery, Long taskId, String userId);
}
