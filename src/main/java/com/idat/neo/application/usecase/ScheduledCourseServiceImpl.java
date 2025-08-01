package com.idat.neo.application.usecase;

import com.idat.neo.domain.model.ScheduledCourse;
import com.idat.neo.domain.repository.ScheduledCourseRepository;
import com.idat.neo.domain.service.ScheduledCourseService;
import com.idat.neo.entrypoints.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduledCourseServiceImpl implements ScheduledCourseService {

    private final ScheduledCourseRepository scheduledCourseRepository;

    @Override
    public List<ScheduledCourse> findAll() {
        return scheduledCourseRepository.findAll();
    }

    @Override
    public ScheduledCourse findById(Long id) {
        return scheduledCourseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Curso Programado no encontrado con id " + id));
    }

    @Override
    public ScheduledCourse save(ScheduledCourse scheduledCourse, Long courseId, Long userId, Long academicCycleId) {
        return scheduledCourseRepository.save(scheduledCourse, courseId, userId, academicCycleId);
    }

    @Override
    public ScheduledCourse update(Long id, ScheduledCourse scheduledCourse, Long courseId, Long userId, Long academicCycleId) {
        ScheduledCourse existing = findById(id);

        ScheduledCourse updateScheduledCourse = new ScheduledCourse(
                existing.id(),
                scheduledCourse.course(),
                scheduledCourse.user(),
                scheduledCourse.academicCycle(),
                scheduledCourse.modality(),
                scheduledCourse.classroom(),
                scheduledCourse.schedule(),
                scheduledCourse.group(),
                scheduledCourse.maxCapacity(),
                scheduledCourse.active()
        );

        return scheduledCourseRepository.update(id, updateScheduledCourse, courseId, userId, academicCycleId);
    }

    @Override
    public void deleteById(Long id) {
        scheduledCourseRepository.deleteById(id);
    }
}
