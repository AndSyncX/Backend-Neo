package com.idat.neo.entrypoints.dto;

import java.time.LocalDate;

public record AssignmentResponseDTO(
        Long id,
        String courseName,
        String teacherName,
        String title,
        String description,
        LocalDate deliveryDate,
        boolean active,
        String status // → Activo / Inactivo
) {
}
