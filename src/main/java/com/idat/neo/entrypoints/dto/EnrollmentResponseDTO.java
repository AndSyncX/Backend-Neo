package com.idat.neo.entrypoints.dto;

import java.time.LocalDate;

public record EnrollmentResponseDTO(
        Long id,
        String userFirstName,
        String userLastName,
        String courseName,
        LocalDate enrollmentDate,
        String status,
        boolean active
) {
}
