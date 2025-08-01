package com.idat.neo.infrastructure.adapter.repository;

import com.idat.neo.domain.model.Assignment;
import com.idat.neo.domain.repository.AssignmentRepository;
import com.idat.neo.infrastructure.adapter.entity.CourseData;
import com.idat.neo.infrastructure.adapter.entity.AssignmentData;
import com.idat.neo.infrastructure.adapter.mapper.AssignmentMapper;
import com.idat.neo.infrastructure.adapter.persistence.CourseDataRepository;
import com.idat.neo.infrastructure.adapter.persistence.AssignmentDataRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AssignmentRepositoryImpl implements AssignmentRepository {

    private final AssignmentDataRepository assignmentDataRepository;
    private final CourseDataRepository courseDataRepository;
    private final AssignmentMapper assignmentMapper;

    @Override
    public List<Assignment> findAll() {
        return assignmentDataRepository.findAll()
                .stream()
                .map(assignmentMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Assignment> findById(Long id) {
        return assignmentDataRepository.findById(id)
                .map(assignmentMapper::toDomain);
    }

    @Override
    public Assignment save(Assignment assignment, Long courseId) {
        /*CourseData courseData = courseDataRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Curso no encontrado con id: " + courseId));

        AssignmentData assignmentData = assignmentMapper.toEntity(assignment);
        assignmentData.setCourseData(courseData);

        AssignmentData saved = assignmentDataRepository.save(assignmentData);
        return assignmentMapper.toDomain(saved);*/
        return null;
    }

    @Override
    public Assignment update(Long id, Assignment assignment, Long courseId) {
        /*AssignmentData existingAssignmentData = assignmentDataRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarea no encontrada con id: " + id));

        CourseData courseData = courseDataRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Curso no encontrado con id: " + courseId));

        existingAssignmentData.setTitle(assignment.title());
        existingAssignmentData.setDescription(assignment.description());
        existingAssignmentData.setDeliveryDate(assignment.deliveryDate());
        existingAssignmentData.setCourseData(courseData);

        AssignmentData updatedAssignmentData = assignmentDataRepository.save(existingAssignmentData);
        return assignmentMapper.toDomain(updatedAssignmentData);*/
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
