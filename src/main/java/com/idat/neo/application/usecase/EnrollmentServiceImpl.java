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
                .orElseThrow(() -> new EntityNotFoundException("Inscripción no encontrado con id: " + id));
    }

    @Override
    public Enrollment save(Enrollment enrollment, Long courseId, Long userId ) {
        return enrollmentRepository.save(enrollment, courseId, userId);
    }

    @Override
    public Enrollment update(Long id, Enrollment enrollment, Long courseId, Long userId) {
        Enrollment existingEnrollment = findById(id);

        Enrollment updatedEnrollment = new Enrollment(
                existingEnrollment.id(),
                enrollment.course(),
                enrollment.user(),
                enrollment.enrollmentDate()
        );

        return enrollmentRepository.update(id, updatedEnrollment, courseId, userId);
    }
}
