package com.idat.neo.domain.model;

public record User(
        String id,
        String name,
        String email,
        String password,
        String role,
        boolean enable
) {
}
