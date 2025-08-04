package com.idat.neo.entrypoints.dto;

public record AssignmentDeliveryResponseDTO(
        Long id,
        String assignmentTitle,
        String userFirstName,
        String userLastName,
        String file,
        Long qualification,
        boolean active,
        String status // → Activo / Inactivo
) {
}
