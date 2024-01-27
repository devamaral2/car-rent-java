package com.fiap.amaralrentcar.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;


public record RentDto(
        @NotNull(message = " O campo startDate não pode estar em branco")
        LocalDateTime startDate,
        @NotNull(message = " O campo expectedEndDate não pode estar em branco")
        LocalDateTime expectedEndDate,
        UUID carId,
        UUID clientId
) {
}
