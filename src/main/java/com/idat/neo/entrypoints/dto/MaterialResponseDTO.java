package com.idat.neo.entrypoints.dto;

import java.time.LocalDate;

public record MaterialResponseDTO(
        Long id,
        String nameCourse,
        String title,
        String description,
        LocalDate uploadDate,
        String fileUrl,
        String fileType,
        boolean isRequired,
        String status, // → Activo / Inactivo
        boolean active
) {
}
