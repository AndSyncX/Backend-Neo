package com.idat.neo.application.usecase;

import com.idat.neo.domain.model.Career;
import com.idat.neo.domain.repository.CareerRepository;
import com.idat.neo.domain.service.CareerService;
import com.idat.neo.entrypoints.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CareerServiceImpl implements CareerService {

    private final CareerRepository careerRepository;

    @Override
    public List<Career> findAll() {
        return careerRepository.findAll();
    }

    @Override
    public Career findById(Long id) {
        return careerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Carrera no encontrada con id " + id));
    }

    @Override
    public List<Career> findActive() {
        return careerRepository.findActive();
    }

    @Override
    public Career findByName(String name) {
        return careerRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Carrera no encontrada con nombre " + name));
    }

    @Override
    public Career save(Career career) {
        return careerRepository.save(career);
    }

    @Override
    public Career update(Long id, Career career) {
        Career existing = findById(id);

        Career updateCareer = new Career(
                existing.id(),
                career.name(),
                career.faculty(),
                career.durationYears(),
                career.active()
        );

        return careerRepository.update(id, updateCareer);
    }

    @Override
    public void deleteById(Long id) {
        careerRepository.findById(id);
    }
}
