package com.idat.neo.entrypoints.dto;

import jakarta.validation.constraints.*;

public record ScheduledCourseRequestDTO(

        @NotNull(message = "El ID del curso es obligatorio")
        Long courseId,

        @NotNull(message = "El ID del docente es obligatorio")
        Long teacherId,

        @NotNull(message = "El ID del ciclo académico es obligatorio")
        Long academicCycleId,

        @NotBlank(message = "La modalidad es obligatoria")
        @Size(max = 50, message = "La modalidad no debe exceder los 50 caracteres")
        String modality,

        @NotBlank(message = "El aula es obligatoria")
        @Size(max = 50, message = "El aula no debe exceder los 50 caracteres")
        String classroom,

        @NotBlank(message = "El horario es obligatorio")
        @Size(max = 100, message = "El horario no debe exceder los 100 caracteres")
        String schedule,

        @NotBlank(message = "El grupo es obligatorio")
        @Size(max = 50, message = "El grupo no debe exceder los 50 caracteres")
        String group,

        @NotNull(message = "La capacidad máxima es obligatoria")
        @Min(value = 20, message = "La capacidad máxima debe ser al menos 20")
        Integer maxCapacity
) {
}
