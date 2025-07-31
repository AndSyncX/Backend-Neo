package com.idat.neo.infrastructure.adapter.repository;

import com.idat.neo.domain.model.AcademicCycle;
import com.idat.neo.domain.repository.AcademicCycleRepository;
import com.idat.neo.infrastructure.adapter.entity.AcademicCycleData;
import com.idat.neo.infrastructure.adapter.mapper.AcademicCycleMapper;
import com.idat.neo.infrastructure.adapter.persistence.AcademicCycleDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AcademicCycleRepositoryImpl implements AcademicCycleRepository {

    private final AcademicCycleDataRepository academicCycleDataRepository;
    private final AcademicCycleMapper academicCycleMapper;

    @Override
    public List<AcademicCycle> findAll() {
        return academicCycleDataRepository.findAll()
                .stream()
                .map(academicCycleMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<AcademicCycle> findById(Long id) {
        return academicCycleDataRepository.findById(id)
                .map(academicCycleMapper::toDomain);
    }

    @Override
    public AcademicCycle save(AcademicCycle academicCycle) {
        AcademicCycleData entity = academicCycleMapper.toEntity(academicCycle);
        entity.setActive(true);
        AcademicCycleData saved = academicCycleDataRepository.save(entity);
        return academicCycleMapper.toDomain(saved);
    }

    @Override
    public AcademicCycle update(Long id, AcademicCycle academicCycle) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
