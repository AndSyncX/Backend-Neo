package com.idat.neo.entrypoints.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record EnrollmentRequestDTO(

        @NotNull(message = "El ID del usuario es obligatorio")
        Long userId,

        @NotNull(message = "El ID del curso programado es obligatorio")
        Long scheduledCourseId,

        @NotNull(message = "La fecha de matrícula es obligatoria")
        LocalDate enrollmentDate

) {
}
