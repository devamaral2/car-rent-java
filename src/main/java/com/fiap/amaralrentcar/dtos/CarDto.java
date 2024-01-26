package com.fiap.amaralrentcar.dtos;

import com.fiap.amaralrentcar.entity.StatusEnum;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record CarDto(
        @NotBlank String plate,
        @NotBlank StatusEnum status,
        @NotBlank String model,
        @NotBlank String year,
        @NotBlank String color,
        @NotNull Integer km,
        @NotBlank String imageUrl,
        @NotBlank String carType,
        @NotNull Double price,
        @Nullable Double power,
        @Nullable String numberOfPassangers,
        @Nullable Double fuelConsumption,
        @Nullable String trunkCapacity) {
}
