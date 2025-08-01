package com.idat.neo.entrypoints.dto;

import jakarta.validation.constraints.NotBlank;

public record PasswordUpdateDTO(

        @NotBlank(message = "La contraseña actual es obligatoria")
        String oldPassword,

        @NotBlank(message = "La nueva contraseña es obligatoria")
        String newPassword
) {}
