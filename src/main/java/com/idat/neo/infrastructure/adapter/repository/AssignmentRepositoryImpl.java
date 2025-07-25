package com.idat.neo.infrastructure.adapter.repository;

import com.idat.neo.domain.model.AssignmentDelivery;
import com.idat.neo.domain.repository.AssignmentDeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AssignmentRepositoryImpl implements AssignmentDeliveryRepository {

    @Override
    public List<AssignmentDelivery> findAll() {
        return List.of();
    }

    @Override
    public Optional<AssignmentDelivery> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public AssignmentDelivery save(AssignmentDelivery assignmentDelivery) {
        return null;
    }
}
