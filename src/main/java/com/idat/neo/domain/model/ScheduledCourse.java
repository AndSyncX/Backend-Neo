package com.idat.neo.domain.model;

public record ScheduledCourse(
        Long id,
        Course course,
        User user, // -> Teacher
        AcademicCycle academicCycle,
        String modality,
        String classroom,
        String schedule,
        String group,
        Integer maxCapacity,
        boolean active
) {
}
