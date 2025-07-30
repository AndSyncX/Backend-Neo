package com.idat.neo.entrypoints.controller;

import com.idat.neo.domain.model.Material;
import com.idat.neo.domain.service.MaterialService;
import com.idat.neo.entrypoints.dto.MaterialRequestDTO;
import com.idat.neo.entrypoints.dto.MaterialResponseDTO;
import com.idat.neo.infrastructure.adapter.mapper.MaterialDtoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/neo/material")
public class MaterialController {

    private final MaterialService materialService;
    private final MaterialDtoMapper materialDtoMapper;

    @GetMapping
    public ResponseEntity<List<MaterialResponseDTO>> getAllMaterials(){
        List<MaterialResponseDTO> response = materialService.findAll()
                .stream()
                .map(materialDtoMapper::toDto)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    ResponseEntity<MaterialResponseDTO> getMaterialById(@PathVariable("id") Long id){
        Material material = materialService.findById(id);
        return ResponseEntity.ok(materialDtoMapper.toDto(material));
    }

    @PostMapping
    public ResponseEntity<MaterialResponseDTO> createMaterial(@RequestBody @Valid MaterialRequestDTO requestDTO) {
        Material materialToSave = materialDtoMapper.toDomain(requestDTO);
        Material savedMaterial = materialService.save(materialToSave, requestDTO.courseId());
        return ResponseEntity.status(HttpStatus.CREATED).body(materialDtoMapper.toDto(savedMaterial));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaterialResponseDTO> updateMaterial(@PathVariable Long id,
                                                          @RequestBody @Valid MaterialRequestDTO requestDTO) {
        Material materialToUpdate = materialDtoMapper.toDomain(requestDTO);
        Material updatedMaterial = materialService.update(id, materialToUpdate, requestDTO.courseId());
        return ResponseEntity.ok(materialDtoMapper.toDto(updatedMaterial));
    }
}
