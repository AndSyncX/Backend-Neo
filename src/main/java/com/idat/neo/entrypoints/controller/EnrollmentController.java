package com.idat.neo.entrypoints.controller;

import com.idat.neo.domain.model.Enrollment;
import com.idat.neo.domain.service.EnrollmentService;
import com.idat.neo.entrypoints.dto.EnrollmentRequestDTO;
import com.idat.neo.entrypoints.dto.EnrollmentResponseDTO;
import com.idat.neo.infrastructure.adapter.mapper.EnrollmentDtoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/neo/enrollment")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;
    private final EnrollmentDtoMapper enrollmentDtoMapper;

    @GetMapping
    public ResponseEntity<List<EnrollmentResponseDTO>> getAllEnrollments() {
        List<EnrollmentResponseDTO> response = enrollmentService.findAll()
                .stream()
                .map(enrollmentDtoMapper::toDto)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentResponseDTO> getEnrollmentById(@PathVariable Long id) {
        Enrollment enrollment = enrollmentService.findById(id);
        return ResponseEntity.ok(enrollmentDtoMapper.toDto(enrollment));
    }

    @PostMapping
    public ResponseEntity<EnrollmentResponseDTO> createEnrollment(@RequestBody @Valid EnrollmentRequestDTO requestDTO) {
        Enrollment toSave = enrollmentDtoMapper.toDomain(requestDTO);
        Enrollment saved = enrollmentService.save(toSave, requestDTO.courseId(), requestDTO.userId());
        return ResponseEntity.ok(enrollmentDtoMapper.toDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentResponseDTO> updateEnrollment(@PathVariable Long id,
                                                                  @RequestBody @Valid EnrollmentRequestDTO requestDTO) {
        Enrollment toUpdate = enrollmentDtoMapper.toDomain(requestDTO);
        Enrollment updated = enrollmentService.update(id, toUpdate, requestDTO.courseId(), requestDTO.userId());
        return ResponseEntity.ok(enrollmentDtoMapper.toDto(updated));
    }
}
