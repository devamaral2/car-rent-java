package com.fiap.amaralrentcar.dtos;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record CarCreateDto(@NotBlank String plate, @NotBlank String status, @NotBlank String model,
                           @NotBlank String year, @NotBlank String color, @NotBlank String km,
                           @NotBlank String imageUrl, @NotBlank String carType, @NotNull Double price,
                           @Nullable Double power,
                           @Nullable String numberOfPassangers, @Nullable Double fuelConsumption,
                           @Nullable String trunkCapacity) {
}
