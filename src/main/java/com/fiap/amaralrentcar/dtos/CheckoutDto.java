package com.fiap.amaralrentcar.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CheckoutDto(
        @NotNull(message = "O campo endDate deve ser preenchido")
        LocalDateTime endDate,
        @NotNull(message = "O campo km deve ser preenchido")
        Integer km
) {
}
