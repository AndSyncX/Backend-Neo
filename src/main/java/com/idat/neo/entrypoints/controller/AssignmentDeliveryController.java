package com.idat.neo.entrypoints.controller;

import com.idat.neo.domain.model.AssignmentDelivery;
import com.idat.neo.domain.service.AssignmentDeliveryService;
import com.idat.neo.entrypoints.dto.AssignmentDeliveryRequestDTO;
import com.idat.neo.entrypoints.dto.AssignmentDeliveryResponseDTO;
import com.idat.neo.infrastructure.adapter.mapper.AssignmentDeliveryDtoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/neo/assignment-delivery")
public class AssignmentDeliveryController {

    private final AssignmentDeliveryService assignmentDeliveryService;
    private final AssignmentDeliveryDtoMapper assignmentDeliveryDtoMapper;

    @GetMapping
    public ResponseEntity<List<AssignmentDeliveryResponseDTO>> getAllDeliveries() {
        List<AssignmentDeliveryResponseDTO> response = assignmentDeliveryService.findAll()
                .stream()
                .map(assignmentDeliveryDtoMapper::toDto)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssignmentDeliveryResponseDTO> getDeliveryById(@PathVariable Long id) {
        AssignmentDelivery delivery = assignmentDeliveryService.findById(id);
        return ResponseEntity.ok(assignmentDeliveryDtoMapper.toDto(delivery));
    }

    @PostMapping
    public ResponseEntity<AssignmentDeliveryResponseDTO> createDelivery(@RequestBody @Valid AssignmentDeliveryRequestDTO requestDTO) {
        AssignmentDelivery toSave = assignmentDeliveryDtoMapper.toDomain(requestDTO);
        AssignmentDelivery saved = assignmentDeliveryService.save(toSave, requestDTO.assignmentId(), requestDTO.userId());
        return ResponseEntity.ok(assignmentDeliveryDtoMapper.toDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssignmentDeliveryResponseDTO> updateDelivery(@PathVariable Long id,
                                                                        @RequestBody @Valid AssignmentDeliveryRequestDTO requestDTO) {
        AssignmentDelivery toUpdate = assignmentDeliveryDtoMapper.toDomain(requestDTO);
        AssignmentDelivery updated = assignmentDeliveryService.update(id, toUpdate, requestDTO.assignmentId(), requestDTO.userId());
        return ResponseEntity.ok(assignmentDeliveryDtoMapper.toDto(updated));
    }
}
