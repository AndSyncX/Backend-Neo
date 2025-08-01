package com.idat.neo.entrypoints.dto;

public record CareerCourseResponseDTO(
        Long id,
        String nameCareer,
        String nameCourse,
        boolean active,
        String status
) {
}
