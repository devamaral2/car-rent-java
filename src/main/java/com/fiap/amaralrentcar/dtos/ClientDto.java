package com.fiap.amaralrentcar.dtos;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClientDto(
        @Email(message = "O email não esta no formato correto")
        @NotBlank(message = " O email não pode estar em branco")
        String email,
        @Nullable
        String name) {
}
