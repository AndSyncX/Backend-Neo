package com.idat.neo.entrypoints.controller;

import com.idat.neo.domain.model.Career;
import com.idat.neo.domain.model.Career;
import com.idat.neo.domain.service.CareerService;
import com.idat.neo.entrypoints.dto.CareerResponseDTO;
import com.idat.neo.entrypoints.dto.CareerRequestDTO;
import com.idat.neo.entrypoints.dto.CareerResponseDTO;
import com.idat.neo.infrastructure.adapter.mapper.CareerDtoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/neo/career")
public class CareerController {

    private final CareerService careerService;
    private final CareerDtoMapper careerDtoMapper;

    @GetMapping
    public ResponseEntity<List<CareerResponseDTO>> getAllCareers() {
        List<CareerResponseDTO> response = careerService.findAll()
                .stream()
                .map(careerDtoMapper::toDto)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CareerResponseDTO> getCareerById(@PathVariable Long id) {
        Career career = careerService.findById(id);
        return ResponseEntity.ok(careerDtoMapper.toDto(career));
    }

    @PostMapping
    public ResponseEntity<CareerResponseDTO> createCareer(@RequestBody @Valid CareerRequestDTO requestDTO) {
        Career careerToSave = careerDtoMapper.toDomain(requestDTO);
        Career savedCareer = careerService.save(careerToSave);
        return ResponseEntity.status(HttpStatus.CREATED).body(careerDtoMapper.toDto(savedCareer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CareerResponseDTO> updateCareer(@PathVariable Long id,
                                                                        @RequestBody @Valid CareerRequestDTO requestDTO) {
        Career careerToUpdate = careerDtoMapper.toDomain(requestDTO);
        Career updatedCareer = careerService.update(id, careerToUpdate);
        return ResponseEntity.ok(careerDtoMapper.toDto(updatedCareer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCareer(@PathVariable Long id) {
        careerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<CareerResponseDTO> getByName(@RequestParam String name) {
        Career career = careerService.findByName(name);
        CareerResponseDTO dto = careerDtoMapper.toDto(career);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/active")
    public ResponseEntity<List<CareerResponseDTO>> getActiveCareer() {
        List<CareerResponseDTO> response = careerService.findActive()
                .stream()
                .map(careerDtoMapper::toDto)
                .toList();
        return ResponseEntity.ok(response);
    }
}
