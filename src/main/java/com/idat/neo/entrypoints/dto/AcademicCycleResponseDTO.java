package com.idat.neo.entrypoints.dto;

import java.time.LocalDate;

public record AcademicCycleResponseDTO(
        Long id,
        String name,
        LocalDate startDate,
        LocalDate endDate,
        String active
) {
}
