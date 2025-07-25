package com.idat.neo.domain.model;

import java.time.LocalDate;

public record Enrollment(
        Long id,
        Course course,
        User user,
        LocalDate enrollmentDate
) {
}
