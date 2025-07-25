package com.idat.neo.application.usecase;

import com.idat.neo.domain.model.AssignmentDelivery;
import com.idat.neo.domain.repository.AssignmentDeliveryRepository;
import com.idat.neo.domain.service.AssignmentDeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssignmentDeliveryServiceImpl implements AssignmentDeliveryService {

    private final AssignmentDeliveryRepository assignmentDeliveryRepository;

    @Override
    public List<AssignmentDelivery> findAll() {
        return assignmentDeliveryRepository.findAll();
    }

    @Override
    public Optional<AssignmentDelivery> findById(Long id) {
        return assignmentDeliveryRepository.findById(id);
    }

    @Override
    public AssignmentDelivery save(AssignmentDelivery assignmentDelivery) {
        return assignmentDeliveryRepository.save(assignmentDelivery);
    }

    @Override
    public AssignmentDelivery update(Long id, AssignmentDelivery assignmentDelivery) {
        return assignmentDeliveryRepository.update(id, assignmentDelivery);
    }

    @Override
    public void deleteById(Long id) {
        assignmentDeliveryRepository.deleteById(id);
    }
}
