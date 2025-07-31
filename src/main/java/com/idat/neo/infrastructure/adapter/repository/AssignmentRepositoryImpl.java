package com.idat.neo.infrastructure.adapter.repository;

import com.idat.neo.domain.model.Assignment;
import com.idat.neo.domain.repository.AssignmentRepository;
import com.idat.neo.infrastructure.adapter.entity.CourseData;
import com.idat.neo.infrastructure.adapter.entity.TaskData;
import com.idat.neo.infrastructure.adapter.mapper.TaskMapper;
import com.idat.neo.infrastructure.adapter.persistence.CourseDataRepository;
import com.idat.neo.infrastructure.adapter.persistence.TaskDataRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AssignmentRepositoryImpl implements AssignmentRepository {

    private final TaskDataRepository taskDataRepository;
    private final CourseDataRepository courseDataRepository;
    private final TaskMapper taskMapper;

    @Override
    public List<Assignment> findAll() {
        return taskDataRepository.findAll()
                .stream()
                .map(taskMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Assignment> findById(Long id) {
        return taskDataRepository.findById(id)
                .map(taskMapper::toDomain);
    }

    @Override
    public Assignment save(Assignment assignment, Long courseId) {
        CourseData courseData = courseDataRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Curso no encontrado con id: " + courseId));

        TaskData taskData = taskMapper.toEntity(assignment);
        taskData.setCourseData(courseData);

        TaskData saved = taskDataRepository.save(taskData);
        return taskMapper.toDomain(saved);
    }

    @Override
    public Assignment update(Long id, Assignment assignment, Long courseId) {
        TaskData existingTaskData = taskDataRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarea no encontrada con id: " + id));

        CourseData courseData = courseDataRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Curso no encontrado con id: " + courseId));

        existingTaskData.setTitle(assignment.title());
        existingTaskData.setDescription(assignment.description());
        existingTaskData.setDeliveryDate(assignment.deliveryDate());
        existingTaskData.setCourseData(courseData);

        TaskData updatedTaskData = taskDataRepository.save(existingTaskData);
        return taskMapper.toDomain(updatedTaskData);
    }
}
