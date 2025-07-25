package com.idat.neo.domain.model;

import java.time.LocalDate;

public record Course(
        Long id,
        String name,
        String description,
        User user,
        LocalDate startDate,
        LocalDate endDate
) {
}
