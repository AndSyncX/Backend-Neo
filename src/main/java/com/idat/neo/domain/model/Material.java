package com.idat.neo.domain.model;

import java.time.LocalDate;

public record Material(
        Long id,
        ScheduledCourse scheduledCourse,
        String title,
        String description,
        LocalDate uploadDate,
        String fileUrl,
        String fileType,
        boolean isRequired,
        boolean active
) {
}
