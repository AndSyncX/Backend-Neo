package com.idat.neo.entrypoints.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AssignmentDeliveryRequestDTO(

        @NotNull(message = "El ID de la tarea es obligatorio")
        Long assignmentId,

        @NotNull(message = "El ID del usuario es obligatorio")
        Long userId,

        @NotBlank(message = "La URL del archivo es obligatoria")
        @Size(max = 80, message = "La URL del archivo no puede exceder los 80 caractéres")
        String file,

        Long qualification
) {
}
