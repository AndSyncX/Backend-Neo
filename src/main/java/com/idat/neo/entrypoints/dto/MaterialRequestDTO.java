package com.idat.neo.entrypoints.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record MaterialRequestDTO(

        @NotNull(message = "El ID del curso es obligatorio")
        Long courseId,

        @NotBlank(message = "El titulo del material es obligatorio")
        @Size(max = 250, message = "El titulo no debe exceder los 250 caracteres")
        String title,

        @Size(max = 500, message = "La descripción no debe exceder los 500 caracteres")
        String description,

        @NotNull(message = "La URL del FireBase es obligatoria")
        String firebaseFileUrl
) {
}
