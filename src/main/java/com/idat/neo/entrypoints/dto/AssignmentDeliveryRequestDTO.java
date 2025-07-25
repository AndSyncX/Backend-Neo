package com.idat.neo.entrypoints.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AssignmentDeliveryRequestDTO(

        @NotNull(message = "El ID de la tarea es obligatorio")
        Long taskId,

        @NotNull(message = "El ID del usuario es obligatorio")
        String userId,

        @NotBlank(message = "La URL del archivo es obligatoria")
        String file

) {
}
