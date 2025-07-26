package com.idat.neo.domain.model;

public record User(
        Long id,
        String name,
        String email,
        String password,
        String role,
        boolean enable
) {
}
