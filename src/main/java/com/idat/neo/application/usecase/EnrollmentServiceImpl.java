package com.idat.neo.application.usecase;

import com.idat.neo.domain.model.Enrollment;
import com.idat.neo.domain.repository.EnrollmentRepository;
import com.idat.neo.domain.service.EnrollmentService;
import jakarta.persistence.EntityNotFoundException;
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
    public Enrollment save(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Enrollment update(Long id, Enrollment enrollment) {
        Enrollment existing = enrollmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Inscripción no encontrado con id: " + id));

        Enrollment updatedEnrollment = new Enrollment(
                id,
                enrollment.course(),
                enrollment.user(),
                enrollment.enrollmentDate()
        );

        return enrollmentRepository.save(updatedEnrollment);
    }
}
