package com.idat.neo.infrastructure.adapter.repository;

import com.idat.neo.domain.model.Enrollment;
import com.idat.neo.domain.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EnrollmentRepositoryImpl implements EnrollmentRepository {
    @Override
    public List<Enrollment> findAll() {
        return List.of();
    }

    @Override
    public Optional<Enrollment> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Enrollment save(Enrollment enrollment) {
        return null;
    }
}
