package com.idat.neo.entrypoints.dto;

import java.time.LocalDate;

public record TaskResponseDTO(
        Long id,
        String courseName,
        String title,
        String description,
        LocalDate deliveryDate
) {
}
