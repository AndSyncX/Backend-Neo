package com.idat.neo.entrypoints.dto;

import java.time.LocalDate;

public record CourseResponseDTO(
        Long id,
        String name,
        String description,
        String userFullName,
        LocalDate startDate,
        LocalDate endDate
) {
}
