package com.idat.neo.entrypoints.dto;

import java.time.LocalDate;

public record UserResponseDTO(
        Long id,
        String firstName,
        String lastName,
        String email,
        Integer dni,
        String phone,
        LocalDate birthDate,
        String address,
        String password,
        String role,
        String status, // → Activo / Inactivo
        boolean active
) {
}
