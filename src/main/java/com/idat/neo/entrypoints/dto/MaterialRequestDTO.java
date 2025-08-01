package com.idat.neo.entrypoints.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record MaterialRequestDTO(

        @NotNull(message = "El ID del curso programado es obligatorio")
        Long scheduledCourseId,

        @NotBlank(message = "El titulo del material es obligatorio")
        @Size(max = 250, message = "El titulo no debe exceder los 250 caracteres")
        String title,

        @Size(max = 500, message = "La descripción no debe exceder los 500 caracteres")
        String description,

        @NotNull(message = "La fecha de subida es obligatoria")
        LocalDate uploadDate,

        @NotBlank(message = "La URL del material es obligatorio")
        @Size(max = 250, message = "La URL no debe exceder los 300 caracteres")
        String fileUrl,

        @NotBlank(message = "El tipo de archivo es obligatorio")
        @Size(max = 250, message = "El tipo de archivo no debe exceder los 30 caracteres")
        String fileType
) {
}
