package com.idat.neo.entrypoints.dto;

public record AssignmentDeliveryResponseDTO(
        Long id,
        String AssignmentTitle,
        String userFirstName,
        String userLastName,
        String file,
        Long qualification,
        boolean active,
        String Status // → Activo / Inactivo
) {
}
