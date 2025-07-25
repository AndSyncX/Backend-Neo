package com.idat.neo.entrypoints.dto;

public record UserResponseDTO(
        String id,
        String name,
        String email,
        String role,
        boolean enable
) {
}
