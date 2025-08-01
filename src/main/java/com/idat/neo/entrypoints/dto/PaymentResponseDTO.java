package com.idat.neo.entrypoints.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PaymentResponseDTO(
        Long id,
        Long enrollmentId,
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
