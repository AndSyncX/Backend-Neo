package com.idat.neo.entrypoints.dto;

public record CourseResponseDTO(
        Long id,
        String name,
        String code,
        Integer credits,
        boolean active,
        String status
) {
}
