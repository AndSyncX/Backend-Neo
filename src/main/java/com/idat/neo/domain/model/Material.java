package com.idat.neo.domain.model;

public record Material(
        Long id,
        Course course,
        String title,
        String description,
        String firebaseFileUrl
) {
}
