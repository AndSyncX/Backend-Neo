package com.idat.neo.entrypoints.dto;

import java.time.LocalDate;

public record EnrollmentResponseDTO(
        Long id,
        String courseName,
        String userFullName,
        LocalDate enrollmentDate
) {
}
