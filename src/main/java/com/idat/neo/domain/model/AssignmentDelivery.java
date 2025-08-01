package com.idat.neo.domain.model;

public record AssignmentDelivery(
        Long id,
        Assignment assignment,
        User user,
        String file,
        Long qualification,
        boolean active
) {
}
