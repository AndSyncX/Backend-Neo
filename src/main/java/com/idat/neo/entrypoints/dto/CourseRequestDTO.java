package com.idat.neo.entrypoints.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CourseRequestDTO(

        @NotBlank(message = "El nombre del curso es obligatorio")
        @Size(max = 100, message = "El nombre no debe exceder los 100 caracteres")
        String name,

        @NotBlank(message = "El código del curso es obligatorio")
        @Size(max = 12, message = "El código no debe exceder los 12 caracteres")
        String code,

        @NotNull(message = "El número de créditos es obligatorio")
        Integer credits
) {
}
