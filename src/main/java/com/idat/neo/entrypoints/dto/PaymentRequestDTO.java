package com.idat.neo.entrypoints.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public record PaymentRequestDTO(

        @NotNull(message = "El ID de la matrícula es obligatorio")
        Long enrollmentId,

        @NotBlank(message = "El tipo de pago es obligatorio")
        @Size(max = 30, message = "El tipo de pago no debe exceder los 30 caracteres")
        String type,

        @NotNull(message = "El número de cuota es obligatorio")
        @Min(value = 1, message = "El número de cuota debe ser mayor o igual a 1")
        Integer installmentNumber,

        @NotNull(message = "El monto es obligatorio")
        @DecimalMin(value = "0.0", inclusive = false, message = "El monto debe ser mayor que cero")
        BigDecimal amount,

        @NotNull(message = "La fecha de vencimiento es obligatoria")
        LocalDate dueDate,

        LocalDate paymentDate,

        @NotBlank(message = "El estado del pago es obligatorio")
        @Pattern(regexp = "PENDIENTE|PAGADO|VENCIDO", message = "El estado debe ser PENDIENTE, PAGADO o VENCIDO")
        String status,

        @NotBlank(message = "El método de pago es obligatorio")
        @Size(max = 30, message = "El método de pago no debe exceder los 30 caracteres")
        String paymentMethod,

        @Size(max = 255, message = "Los comentarios no deben exceder los 255 caracteres")
        String notes
) {
}
