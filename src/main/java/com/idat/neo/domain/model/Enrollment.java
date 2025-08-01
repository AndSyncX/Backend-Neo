package com.idat.neo.domain.model;

import java.time.LocalDate;

public record Enrollment(
        Long id,
        User user,
        ScheduledCourse scheduledCourse,
        LocalDate enrollmentDate,
        String status,
        boolean active
) {
}
