package com.idat.neo.entrypoints.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CourseRequestDTO(
        @NotBlank(message = "El nombre del curso es obligatorio")
        @Size(max = 250, message = "El nombre no debe exceder los 250 caracteres")
        String name,

        @Size(max = 500, message = "La descripción no debe exceder los 500 caracteres")
        String description,

        @NotNull(message = "El ID del usuario es obligatorio")
        String userId,

        @NotNull(message = "La fecha de inicio es obligatoria")
        LocalDate startDate,

        @NotNull(message = "La fecha de fin es obligatoria")
        LocalDate endDate
) {
}
