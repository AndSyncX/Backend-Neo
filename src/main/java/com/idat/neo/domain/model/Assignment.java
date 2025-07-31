package com.idat.neo.domain.model;

import java.time.LocalDate;

public record Assignment(
        Long id,
        ScheduledCourse scheduledCourse,
        String title,
        String description,
        LocalDate deliveryDate
) {
}
