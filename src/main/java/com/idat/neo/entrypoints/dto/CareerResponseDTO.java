package com.idat.neo.entrypoints.dto;

public record CareerResponseDTO(
        Long id,
        String name,
        String faculty,
        String durationYears,
        String active
) {
}
