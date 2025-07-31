package com.idat.neo.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Payment(
        Long id,
        Enrollment enrollment,
        String type,
        Integer installmentNumber,
        BigDecimal amount,
        LocalDate dueDate,
        LocalDate paymentDate,
        String status,
        String paymentMethod,
        String notes
) {
}
