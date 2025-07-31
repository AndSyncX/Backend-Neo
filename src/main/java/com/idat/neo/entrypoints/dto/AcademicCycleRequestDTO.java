package com.idat.neo.entrypoints.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AcademicCycleRequestDTO(

        @NotBlank(message = "El nombre del ciclo académico es obligatorio")
        String name,

        @NotNull(message = "La fecha de inicio es obligatoria")
        LocalDate startDate,

        @NotNull(message = "La fecha de culminación es obligatoria")
        LocalDate endDate
) {
}
