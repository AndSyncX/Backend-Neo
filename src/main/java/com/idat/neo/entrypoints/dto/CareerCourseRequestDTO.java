package com.idat.neo.entrypoints.dto;

import jakarta.validation.constraints.NotNull;

public record CareerCourseRequestDTO(

        @NotNull(message = "El id de la carrera es obligatorio")
        Long careerId,

        @NotNull(message = "El id del curso es obligatorio")
        Long courseId
) {
}
