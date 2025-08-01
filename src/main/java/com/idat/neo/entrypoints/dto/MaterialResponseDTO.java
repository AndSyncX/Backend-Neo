package com.idat.neo.entrypoints.dto;

import com.idat.neo.domain.model.ScheduledCourse;

import java.time.LocalDate;

public record MaterialResponseDTO(
        Long id,
        ScheduledCourse scheduledCourse,
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
