package com.idat.neo.domain.model;

import java.time.LocalDate;

public record User(
        Long id,
        String firstName,
        String lastName,
        String email,
        String dni,
        String phone,
        LocalDate birthDate,
        String address,
        String password,
        String role,
        boolean active
) {
}
