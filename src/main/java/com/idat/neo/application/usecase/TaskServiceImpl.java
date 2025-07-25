package com.idat.neo.application.usecase;

import com.idat.neo.domain.model.Task;
import com.idat.neo.domain.repository.TaskRepository;
import com.idat.neo.domain.service.TaskService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarea no encontrada con id" + id));
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task update(Long id, Task task) {
        Task existing = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task no encontrado con id: " + id));

        Task updatedTask = new Task(
                id,
                task.course(),
                task.title(),
                task.description(),
                task.deliveryDate()
        );

        return taskRepository.save(updatedTask);
    }
}
