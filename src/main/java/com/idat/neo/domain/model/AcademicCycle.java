package com.idat.neo.domain.model;

import java.time.LocalDate;

public record AcademicCycle(
        Long id,
        String name,
        LocalDate startDate,
        LocalDate endDate
) {
}
