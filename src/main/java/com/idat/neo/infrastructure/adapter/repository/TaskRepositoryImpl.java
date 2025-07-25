package com.idat.neo.infrastructure.adapter.repository;

import com.idat.neo.domain.model.Task;
import com.idat.neo.domain.repository.TaskRepository;
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
public class TaskRepositoryImpl implements TaskRepository {

    private final TaskDataRepository taskDataRepository;
    private final CourseDataRepository courseDataRepository;
    private final TaskMapper taskMapper;

    @Override
    public List<Task> findAll() {
        return taskDataRepository.findAll()
                .stream()
                .map(taskMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskDataRepository.findById(id)
                .map(taskMapper::toDomain);
    }

    @Override
    public Task save(Task task) {
        CourseData courseData = courseDataRepository.findById(task.course().id())
                .orElseThrow(() -> new EntityNotFoundException("Curso no encontrado con id: " + task.course().id()));

        TaskData taskData = taskMapper.toEntity(task);
        taskData.setCourseData(courseData);

        TaskData saved = taskDataRepository.save(taskData);
        return taskMapper.toDomain(saved);
    }
}
