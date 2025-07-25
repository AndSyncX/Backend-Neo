package com.idat.neo.entrypoints.dto;

public record AssignmentDeliveryResponseDTO(
        Long id,
        String taskTitle,
        String userFullName,
        String file,
        Long qualification
) {
}
