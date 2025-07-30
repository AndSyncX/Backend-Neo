package com.idat.neo.application.usecase;

import com.idat.neo.domain.model.AssignmentDelivery;
import com.idat.neo.domain.repository.AssignmentDeliveryRepository;
import com.idat.neo.domain.service.AssignmentDeliveryService;
import com.idat.neo.entrypoints.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignmentDeliveryServiceImpl implements AssignmentDeliveryService {

    private final AssignmentDeliveryRepository assignmentDeliveryRepository;

    @Override
    public List<AssignmentDelivery> findAll() {
        return assignmentDeliveryRepository.findAll();
    }

    @Override
    public AssignmentDelivery findById(Long id) {
        return assignmentDeliveryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Asignar tarea no encontrado con id: " + id));
    }

    @Override
    public AssignmentDelivery save(AssignmentDelivery assignmentDelivery, Long taskId, Long userId) {
        return assignmentDeliveryRepository.save(assignmentDelivery, taskId, userId);
    }

    @Override
    public AssignmentDelivery update(Long id, AssignmentDelivery assignmentDelivery, Long taskId, Long userId) {
        AssignmentDelivery existingAssignmentDelivery = findById(id);

        AssignmentDelivery updatedAssignmentDelivery = new AssignmentDelivery(
                existingAssignmentDelivery.id(),
                assignmentDelivery.task(),
                assignmentDelivery.user(),
                assignmentDelivery.file(),
                assignmentDelivery.qualification()
        );

        return assignmentDeliveryRepository.update(id, updatedAssignmentDelivery, taskId, userId);
    }
}
