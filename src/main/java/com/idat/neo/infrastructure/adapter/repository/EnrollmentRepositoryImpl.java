package com.idat.neo.infrastructure.adapter.repository;

import com.idat.neo.domain.model.Enrollment;
import com.idat.neo.domain.repository.EnrollmentRepository;
import com.idat.neo.infrastructure.adapter.entity.EnrollmentData;
import com.idat.neo.infrastructure.adapter.entity.CourseData;
import com.idat.neo.infrastructure.adapter.entity.UserData;
import com.idat.neo.infrastructure.adapter.mapper.EnrollmentMapper;
import com.idat.neo.infrastructure.adapter.persistence.EnrollmentDataRepository;
import com.idat.neo.infrastructure.adapter.persistence.CourseDataRepository;
import com.idat.neo.infrastructure.adapter.persistence.UserDataRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EnrollmentRepositoryImpl implements EnrollmentRepository {

    private final EnrollmentDataRepository enrollmentDataRepository;
    private final CourseDataRepository courseDataRepository;
    private final UserDataRepository userDataRepository;
    private final EnrollmentMapper enrollmentMapper;

    @Override
    public List<Enrollment> findAll() {
        return enrollmentDataRepository.findAll()
                .stream()
                .map(enrollmentMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Enrollment> findById(Long id) {
        return enrollmentDataRepository.findById(id)
                .map(enrollmentMapper::toDomain);
    }

    @Override
    public Optional<Enrollment> findByStatus(String status) {
        return enrollmentDataRepository.findByStatus(status)
                .map(enrollmentMapper::toDomain);
    }

    @Override
    public Enrollment save(Enrollment enrollment, Long courseId, Long userId) {
        CourseData courseData = courseDataRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Curso no encontrado con id: " + courseId));
        UserData userData = userDataRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con id: " + userId));

        EnrollmentData data = enrollmentMapper.toEntity(enrollment);
       // data.setCourseData(courseData);
        data.setUserData(userData);

        EnrollmentData saved = enrollmentDataRepository.save(data);
        return enrollmentMapper.toDomain(saved);
    }

    @Override
    public Enrollment update(Long id, Enrollment enrollment, Long courseId, Long userId) {
        EnrollmentData existing = enrollmentDataRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Matrícula no encontrada con id: " + id));

        CourseData courseData = courseDataRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Curso no encontrado con id: " + courseId));
        UserData userData = userDataRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con id: " + userId));

        //existing.setCourseData(courseData);
        existing.setUserData(userData);
        existing.setEnrollmentDate(enrollment.enrollmentDate());

        EnrollmentData updated = enrollmentDataRepository.save(existing);
        return enrollmentMapper.toDomain(updated);
    }

    @Override
    public void deleteById(Long id) {

    }
}
