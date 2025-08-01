package com.idat.neo.application.usecase;

import com.idat.neo.entrypoints.exception.EntityNotFoundException;
import com.idat.neo.domain.model.Assignment;
import com.idat.neo.domain.repository.AssignmentRepository;
import com.idat.neo.domain.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignmentServiceImpl implements AssignmentService {

    private final AssignmentRepository assignmentRepository;

    @Override
    public List<Assignment> findAll() {
        return assignmentRepository.findAll();
    }

    @Override
    public Assignment findById(Long id) {
        return assignmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarea no encontrada con id " + id));
    }

    @Override
    public Assignment save(Assignment assignment, Long scheduledCourseId) {
        return assignmentRepository.save(assignment, scheduledCourseId);
    }

    @Override
    public Assignment update(Long id, Assignment assignment, Long scheduledCourseId) {
        Assignment existing = findById(id);

        Assignment updateAssignment = new Assignment(
                existing.id(),
                assignment.scheduledCourse(),
                assignment.title(),
                assignment.description(),
                assignment.deliveryDate(),
                assignment.active()
        );

        return assignmentRepository.update(id, updateAssignment, scheduledCourseId);
    }

    @Override
    public void deleteById(Long id) {
        assignmentRepository.deleteById(id);
    }
}
