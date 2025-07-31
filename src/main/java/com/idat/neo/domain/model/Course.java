package com.idat.neo.domain.model;

public record Course(
        Long id,
        String name,
        String code,
        Integer credits,
        boolean active
) {
}
