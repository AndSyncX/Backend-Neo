package com.idat.neo.entrypoints.dto;

import jakarta.validation.constraints.NotBlank;

public record CareerRequestDTO(

        @NotBlank(message = "Nombre de la carrera es obligatorio")
        String name,

        @NotBlank(message = "Nombre de la facultad es obligatorio")
        String faculty,

        @NotBlank(message = "Duración de la carrera es obligatorio")
        String durationYears
) {
}
