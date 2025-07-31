package com.idat.neo.application.usecase;

import com.idat.neo.domain.model.AcademicCycle;
import com.idat.neo.domain.repository.AcademicCycleRepository;
import com.idat.neo.domain.service.AcademicCycleService;
import com.idat.neo.entrypoints.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AcademicCycleServiceImpl implements AcademicCycleService {

    private final AcademicCycleRepository academicCycleRepository;

    @Override
    public List<AcademicCycle> findAll() {
        return academicCycleRepository.findAll();
    }

    @Override
    public AcademicCycle findById(Long id) {
        return academicCycleRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Ciclo Académico no encontrado con id "+ id));
    }

    @Override
    public AcademicCycle save(AcademicCycle academicCycle) {
        return academicCycleRepository.save(academicCycle);
    }

    @Override
    public AcademicCycle update(Long id, AcademicCycle academicCycle) {
        AcademicCycle existing = findById(id);

        AcademicCycle updateAcademicCycle = new AcademicCycle(
                existing.id(),
                academicCycle.name(),
                academicCycle.startDate(),
                academicCycle.endDate()
        );

        return academicCycleRepository.update(id, updateAcademicCycle);
    }

    @Override
    public void deleteById(Long id) {
        academicCycleRepository.deleteById(id);
    }
}
