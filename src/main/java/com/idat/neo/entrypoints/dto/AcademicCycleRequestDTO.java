package com.idat.neo.entrypoints.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AcademicCycleRequestDTO(

        @NotBlank(message = "El nombre del ciclo académico es obligatorio")
        @Size(max = 30, message = "El nombre del ciclo no debe exceder los 30 caracteres")
        String name,

        @NotNull(message = "La fecha de inicio es obligatoria")
        LocalDate startDate,

        @NotNull(message = "La fecha de culminación es obligatoria")
        LocalDate endDate
) {
}
