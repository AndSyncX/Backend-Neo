package com.idat.neo.entrypoints.dto;

public record MaterialResponseDTO(
        Long id,
        String courseName,
        String title,
        String description,
        String firebaseFileUrl
) {
}
