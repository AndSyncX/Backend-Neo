package com.idat.neo.entrypoints.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AssignmentRequestDTO(

        @NotNull(message = "El ID del curso programado es obligatorio")
        Long scheduledCourseId,

        @NotBlank(message = "El titulo de la tarea es obligatorio")
        @Size(max = 200, message = "El titulo de la tarea no debe exceder los 200 caracteres")
        String title,

        @Size(max = 500, message = "La descripción no debe exceder los 500 caracteres")
        String description,

        @NotNull(message = "La fecha de entrega es obligatoria")
        LocalDate deliveryDate
) {
}
