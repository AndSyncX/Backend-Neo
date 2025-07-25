package com.idat.neo.infrastructure.adapter.repository;

import com.idat.neo.domain.model.Task;
import com.idat.neo.domain.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TaskRepositoryImpl implements TaskRepository {
    @Override
    public List<Task> findAll() {
        return List.of();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Task save(Task task) {
        return null;
    }
}
