package com.idat.neo.entrypoints.controller;

import com.idat.neo.domain.model.Task;
import com.idat.neo.domain.service.TaskService;
import com.idat.neo.entrypoints.dto.TaskRequestDTO;
import com.idat.neo.entrypoints.dto.TaskResponseDTO;
import com.idat.neo.infrastructure.adapter.mapper.TaskDtoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/neo/task")
public class TaskController {

    private final TaskService taskService;
    private final TaskDtoMapper taskDtoMapper;

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks(){
        List<TaskResponseDTO> response = taskService.findAll()
                .stream()
                .map(taskDtoMapper::toDto)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable("id") Long id){
        Task task = taskService.findById(id);
        return ResponseEntity.ok(taskDtoMapper.toDto(task));
    }

    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody @Valid TaskRequestDTO requestDTO) {
        Task savedTask = taskService.save(taskDtoMapper.toDomain(requestDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(taskDtoMapper.toDto(savedTask));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> updateTask(@PathVariable Long id,
                                                              @RequestBody @Valid TaskRequestDTO requestDTO) {
        Task updated = taskService.update(id, taskDtoMapper.toDomain(requestDTO));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(taskDtoMapper.toDto(updated));
    }
}
