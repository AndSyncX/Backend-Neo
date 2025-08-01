package com.idat.neo.entrypoints.dto;

public record ScheduledCourseResponseDTO(
        Long id,
        String nameCourse,
        String userFirstName,
        String userLastName,
        String nameAcademicCycle,
        String modality,
        String classroom,
        String schedule,
        String group,
        Integer maxCapacity,
        boolean active
) {
}
