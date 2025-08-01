package com.idat.neo.entrypoints.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CareerRequestDTO(

        @NotBlank(message = "Nombre de la carrera es obligatorio")
        @Size(max = 50, message = "El nombre de la carrera no debe exceder los 50 caracteres")
        String name,

        @NotBlank(message = "Nombre de la facultad es obligatorio")
        @Size(max = 50, message = "La facultad de la carrera no debe exceder los 50 caracteres")
        String faculty,

        @NotBlank(message = "Duración de la carrera es obligatorio")
        @Size(max = 20, message = "El año de duración no debe exceder los 10 caracteres")
        String durationYears
) {
}
