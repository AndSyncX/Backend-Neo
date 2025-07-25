package com.idat.neo.infrastructure.adapter.repository;

import com.idat.neo.domain.model.AssignmentDelivery;
import com.idat.neo.domain.repository.AssignmentDeliveryRepository;
import com.idat.neo.infrastructure.adapter.entity.AssignmentDeliveryData;
import com.idat.neo.infrastructure.adapter.entity.TaskData;
import com.idat.neo.infrastructure.adapter.entity.UserData;
import com.idat.neo.infrastructure.adapter.mapper.AssignmentDeliveryMapper;
import com.idat.neo.infrastructure.adapter.persistence.AssignmentDeliveryDataRepository;
import com.idat.neo.infrastructure.adapter.persistence.TaskDataRepository;
import com.idat.neo.infrastructure.adapter.persistence.UserDataRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AssignmentDeliveryRepositoryImpl implements AssignmentDeliveryRepository {

    private final AssignmentDeliveryDataRepository deliveryDataRepository;
    private final TaskDataRepository taskDataRepository;
    private final UserDataRepository userDataRepository;
    private final AssignmentDeliveryMapper assignmentDeliveryMapper;

    @Override
    public List<AssignmentDelivery> findAll() {
        return deliveryDataRepository.findAll()
                .stream()
                .map(assignmentDeliveryMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<AssignmentDelivery> findById(Long id) {
        return deliveryDataRepository.findById(id)
                .map(assignmentDeliveryMapper::toDomain);
    }

    @Override
    public AssignmentDelivery save(AssignmentDelivery delivery, Long taskId, String userId) {
        TaskData taskData = taskDataRepository.findById(taskId)
                .orElseThrow(() -> new EntityNotFoundException("Tarea no encontrada con id: " + taskId));
        UserData userData = userDataRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con id: " + userId));

        AssignmentDeliveryData data = assignmentDeliveryMapper.toEntity(delivery);
        data.setTaskData(taskData);
        data.setUserData(userData);

        AssignmentDeliveryData saved = deliveryDataRepository.save(data);
        return assignmentDeliveryMapper.toDomain(saved);
    }

    @Override
    public AssignmentDelivery update(Long id, AssignmentDelivery delivery, Long taskId, String userId) {
        AssignmentDeliveryData existing = deliveryDataRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entrega no encontrada con id: " + id));

        TaskData taskData = taskDataRepository.findById(taskId)
                .orElseThrow(() -> new EntityNotFoundException("Tarea no encontrada con id: " + taskId));
        UserData userData = userDataRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con id: " + userId));

        existing.setTaskData(taskData);
        existing.setUserData(userData);
        existing.setFile(delivery.file());
        existing.setQualification(delivery.qualification());

        AssignmentDeliveryData updated = deliveryDataRepository.save(existing);
        return assignmentDeliveryMapper.toDomain(updated);
    }
}
