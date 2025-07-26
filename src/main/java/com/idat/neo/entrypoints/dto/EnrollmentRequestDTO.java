package com.idat.neo.entrypoints.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record EnrollmentRequestDTO(

        @NotNull(message = "El ID del curso es obligatorio")
        Long courseId,

        @NotNull(message = "El ID del usuario es obligatorio")
        Long userId,

        @NotNull(message = "La fecha de inscripción es obligatoria")
        LocalDate enrollmentDate

) {
}
