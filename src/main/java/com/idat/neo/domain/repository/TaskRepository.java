package com.idat.neo.domain.repository;

import com.idat.neo.domain.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    List<Task> findAll();
    Optional<Task> findById(Long id);
    Task save(Task task, Long courseId);
    Task update(Long id, Task task, Long courseId);
}
