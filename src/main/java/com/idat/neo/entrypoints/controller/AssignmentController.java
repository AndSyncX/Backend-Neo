package com.idat.neo.entrypoints.controller;

import com.idat.neo.domain.model.Assignment;
import com.idat.neo.domain.service.AssignmentService;
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
public class AssignmentController {

    private final AssignmentService assignmentService;
    private final TaskDtoMapper taskDtoMapper;

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks(){
        List<TaskResponseDTO> response = assignmentService.findAll()
                .stream()
                .map(taskDtoMapper::toDto)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable("id") Long id){
        Assignment assignment = assignmentService.findById(id);
        return ResponseEntity.ok(taskDtoMapper.toDto(assignment));
    }

    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody @Valid TaskRequestDTO requestDTO) {
        Assignment assignmentToSave = taskDtoMapper.toDomain(requestDTO);
        Assignment savedAssignment = assignmentService.save(assignmentToSave, requestDTO.courseId());
        return ResponseEntity.status(HttpStatus.CREATED).body(taskDtoMapper.toDto(savedAssignment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> updateTask(@PathVariable Long id,
                                                      @RequestBody @Valid TaskRequestDTO requestDTO) {
        Assignment assignmentToUpdate = taskDtoMapper.toDomain(requestDTO);
        Assignment updatedAssignment = assignmentService.update(id, assignmentToUpdate, requestDTO.courseId());
        return ResponseEntity.ok(taskDtoMapper.toDto(updatedAssignment));
    }
}
