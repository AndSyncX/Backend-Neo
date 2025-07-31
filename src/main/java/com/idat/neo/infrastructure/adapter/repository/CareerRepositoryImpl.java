package com.idat.neo.infrastructure.adapter.repository;

import com.idat.neo.domain.model.Career;
import com.idat.neo.domain.repository.CareerRepository;
import com.idat.neo.entrypoints.exception.EntityNotFoundException;
import com.idat.neo.infrastructure.adapter.entity.CareerData;
import com.idat.neo.infrastructure.adapter.mapper.CareerMapper;
import com.idat.neo.infrastructure.adapter.persistence.CareerDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CareerRepositoryImpl implements CareerRepository {

    private final CareerDataRepository careerDataRepository;
    private final CareerMapper careerMapper;

    @Override
    public List<Career> findAll() {
        return careerDataRepository.findAll()
                .stream()
                .map(careerMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Career> findById(Long id) {
        return careerDataRepository.findById(id)
                .map(careerMapper::toDomain);
    }

    @Override
    public Career save(Career career) {
        CareerData entity = careerMapper.toEntity(career);
        entity.setActive(true);
        CareerData saved = careerDataRepository.save(entity);
        return careerMapper.toDomain(saved);
    }

    @Override
    public Career update(Long id, Career career) {
        CareerData existing = careerDataRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Carrera no encontrada con id " + id));

        existing.setName(career.name());
        existing.setFaculty(career.faculty());
        existing.setDurationYears(career.durationYears());
        existing.setActive(career.active());

        CareerData update = careerDataRepository.save(existing);
        return careerMapper.toDomain(update);
    }

    @Override
    public void deleteById(Long id) {
        CareerData existing = careerDataRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Carrera no encontrada con id " + id));

        existing.setActive(false);
        careerDataRepository.save(existing);
    }
}
