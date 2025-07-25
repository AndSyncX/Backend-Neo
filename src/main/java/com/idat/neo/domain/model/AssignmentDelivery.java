package com.idat.neo.domain.model;

public record AssignmentDelivery(
        Long id,
        Task task,
        User user,
        String file,
        Long qualification
) {
}
