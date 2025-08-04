package com.idat.neo.entrypoints.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record UserRequestDTO(

        @NotBlank(message = "El nombre es obligatorio")
        @Size(max = 70, message = "El nombre no debe exceder los 70 caracteres")
        String firstName,

        @NotBlank(message = "El apellido es obligatorio")
        @Size(max = 70, message = "El apellido no debe exceder los 70 caracteres")
        String lastName,

        @NotBlank(message = "El correo electrónico es obligatorio")
        @Email(message = "El correo electrónico no es válido")
        @Size(max = 200, message = "El correo no debe exceder los 200 caracteres")
        String email,

        @NotBlank(message = "El DNI es obligatorio")
        @Size(max = 12, message = "El DNI no debe exceder los 12 caracteres")
        String dni,

        @NotBlank(message = "El teléfono es obligatorio")
        @Size(max = 12, message = "El teléfono no debe exceder los 12 caracteres")
        String phone,

        @NotNull(message = "La fecha de nacimiento es obligatoria")
        LocalDate birthDate,

        @NotBlank(message = "La contraseña es obligatoria")
        String password,

        @NotBlank(message = "La dirección es obligatoria")
        @Size(max = 300, message = "La dirección no debe exceder los 300 caracteres")
        String address,

        @NotBlank(message = "El rol es obligatorio")
        @Size(max = 10, message = "El rol no debe exceder los 10 caracteres")
        String role

) {
}
