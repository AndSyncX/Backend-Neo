package com.idat.neo.entrypoints.controller;

import com.idat.neo.domain.model.AcademicCycle;
import com.idat.neo.domain.service.AcademicCycleService;
import com.idat.neo.entrypoints.dto.AcademicCycleRequestDTO;
import com.idat.neo.entrypoints.dto.AcademicCycleResponseDTO;
import com.idat.neo.infrastructure.adapter.mapper.AcademicCycleDtoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/neo/academic-cycles")
public class AcademicCycleController {
    
    private final AcademicCycleService academicCycleService;
    private final AcademicCycleDtoMapper academicCycleDtoMapper;

    @GetMapping
    public ResponseEntity<List<AcademicCycleResponseDTO>> getAllAcademicCycles() {
        List<AcademicCycleResponseDTO> response = academicCycleService.findAll()
                .stream()
                .map(academicCycleDtoMapper::toDto)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicCycleResponseDTO> getAcademicCycleById(@PathVariable Long id) {
        AcademicCycle academicCycle = academicCycleService.findById(id);
        return ResponseEntity.ok(academicCycleDtoMapper.toDto(academicCycle));
    }

    @GetMapping("/search")
    public ResponseEntity<AcademicCycleResponseDTO> getByName(@RequestParam String name) {
        AcademicCycle academicCycle = academicCycleService.findByName(name);
        AcademicCycleResponseDTO dto = academicCycleDtoMapper.toDto(academicCycle);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/active")
    public ResponseEntity<List<AcademicCycleResponseDTO>> getActiveAcademicCycle() {
        List<AcademicCycleResponseDTO> response = academicCycleService.findActive()
                .stream()
                .map(academicCycleDtoMapper::toDto)
                .toList();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<AcademicCycleResponseDTO> createAcademicCycle(@RequestBody @Valid AcademicCycleRequestDTO requestDTO) {
        AcademicCycle academicCycleToSave = academicCycleDtoMapper.toDomain(requestDTO);
        AcademicCycle savedAcademicCycle = academicCycleService.save(academicCycleToSave);
        return ResponseEntity.status(HttpStatus.CREATED).body(academicCycleDtoMapper.toDto(savedAcademicCycle));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcademicCycleResponseDTO> updateAcademicCycle(@PathVariable Long id,
                                                      @RequestBody @Valid AcademicCycleRequestDTO requestDTO) {
        AcademicCycle academicCycleToUpdate = academicCycleDtoMapper.toDomain(requestDTO);
        AcademicCycle updatedAcademicCycle = academicCycleService.update(id, academicCycleToUpdate);
        return ResponseEntity.ok(academicCycleDtoMapper.toDto(updatedAcademicCycle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAcademicCycle(@PathVariable Long id) {
        academicCycleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
