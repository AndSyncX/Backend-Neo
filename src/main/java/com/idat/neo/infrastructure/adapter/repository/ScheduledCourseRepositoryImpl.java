package com.idat.neo.infrastructure.adapter.repository;

import com.idat.neo.domain.model.ScheduledCourse;
import com.idat.neo.domain.repository.ScheduledCourseRepository;
import com.idat.neo.entrypoints.exception.EntityNotFoundException;
import com.idat.neo.infrastructure.adapter.entity.ScheduledCourseData;
import com.idat.neo.infrastructure.adapter.mapper.ScheduledCourseMapper;
import com.idat.neo.infrastructure.adapter.persistence.ScheduledCourseDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ScheduledCourseRepositoryImpl implements ScheduledCourseRepository {

    private final ScheduledCourseDataRepository scheduledCourseDataRepository;
    private final ScheduledCourseMapper scheduledCourseMapper;

    @Override
    public List<ScheduledCourse> findAll() {
        return scheduledCourseDataRepository.findAll()
                .stream()
                .map(scheduledCourseMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<ScheduledCourse> findById(Long id) {
        return scheduledCourseDataRepository.findById(id)
                .map(scheduledCourseMapper::toDomain);
    }

    @Override
    public ScheduledCourse save(ScheduledCourse scheduledCourse, Long courseId, Long userId, Long academicCycleId) {
        ScheduledCourseData entity = scheduledCourseMapper.toEntity(scheduledCourse);
        ScheduledCourseData saved = scheduledCourseDataRepository.save(entity);
        return scheduledCourseMapper.toDomain(saved);
    }

    @Override
    public ScheduledCourse update(Long id, ScheduledCourse scheduledCourse, Long courseId, Long userId, Long academicCycleId) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        ScheduledCourseData existing = scheduledCourseDataRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Curso programado no encontrado con id " + id));
        scheduledCourseDataRepository.delete(existing);
    }
}
