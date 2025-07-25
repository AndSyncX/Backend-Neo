package com.idat.neo.domain.model;

import java.time.LocalDate;

public record Task(
        Long id,
        Course course,
        String title,
        String description,
        LocalDate deliveryDate
) {
}
