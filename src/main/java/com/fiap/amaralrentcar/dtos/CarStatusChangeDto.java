package com.fiap.amaralrentcar.dtos;

import jakarta.validation.constraints.NotBlank;

public record CarStatusChangeDto(
        @NotBlank(message = "O campo status deve ser preenchido")
        String status) {
}
