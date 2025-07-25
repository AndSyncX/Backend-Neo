package com.idat.neo.domain.service;

import com.idat.neo.domain.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAll();
    Task findById(Long id);
    Task save(Task task, Long courseId);
    Task update(Long id, Task task, Long courseId);
}
