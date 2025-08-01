package com.idat.neo.application.usecase;

import com.idat.neo.domain.model.Enrollment;
import com.idat.neo.domain.repository.EnrollmentRepository;
import com.idat.neo.domain.service.EnrollmentService;
import com.idat.neo.entrypoints.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    @Override
    public List<Enrollment> findAll() {
        return enrollmentRepository.findAll();
    }

    @Override
    public Enrollment findById(Long id) {
        return enrollmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Matricula no encontrada con id "+ id));
    }

    @Override
    public Enrollment findByStatus(String status) {
        return enrollmentRepository.findByStatus(status)
                .orElseThrow(() -> new EntityNotFoundException("Matrícula no encontrada con estado "+ status));
    }

    @Override
    public Enrollment save(Enrollment enrollment, Long userId, Long scheduledCourseId) {
        return enrollmentRepository.save(enrollment, userId, scheduledCourseId);
    }

    @Override
    public Enrollment update(Long id, Enrollment enrollment, Long userId, Long scheduledCourseId) {
        Enrollment existing = findById(id);

        Enrollment updateEnrollment = new Enrollment(
                existing.id(),
                enrollment.user(),
                enrollment.scheduledCourse(),
                enrollment.enrollmentDate(),
                enrollment.status(),
                enrollment.active()
        );

        return enrollmentRepository.update(id, updateEnrollment, userId, scheduledCourseId);
    }

    @Override
    public void deleteById(Long id) {
        enrollmentRepository.deleteById(id);
    }
}
