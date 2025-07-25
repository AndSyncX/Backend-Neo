package com.idat.neo.application.usecase;

import com.idat.neo.domain.model.AssignmentDelivery;
import com.idat.neo.domain.model.Course;
import com.idat.neo.domain.repository.AssignmentDeliveryRepository;
import com.idat.neo.domain.service.AssignmentDeliveryService;
import jakarta.persistence.EntityNotFoundException;
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
    public AssignmentDelivery save(AssignmentDelivery assignmentDelivery) {
        return assignmentDeliveryRepository.save(assignmentDelivery);
    }

    @Override
    public AssignmentDelivery update(Long id, AssignmentDelivery assignmentDelivery) {
        AssignmentDelivery existing = assignmentDeliveryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Asignar tarea no encontrado con id: " + id));

        AssignmentDelivery updatedAssignmentDelivery = new AssignmentDelivery(
                id,
                assignmentDelivery.task(),
                assignmentDelivery.user(),
                assignmentDelivery.file(),
                assignmentDelivery.qualification()
        );

        return assignmentDeliveryRepository.save(updatedAssignmentDelivery);
    }
}
