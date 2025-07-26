package com.idat.neo.entrypoints.dto;

public record UserResponseDTO(
        Long id,
        String name,
        String email,
        String role,
        boolean enable
) {
}
