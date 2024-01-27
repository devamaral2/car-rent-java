package com.fiap.amaralrentcar.dtos;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record CarDto(
        @NotBlank(message = "O campo plate deve ser preenchido. ")
        String plate,
        @NotBlank(message = "O campo status deve ser preenchido. ")
        String status,
        @NotBlank(message = "O campo model deve ser preenchido. ")
        String model,
        @NotBlank(message = "O campo year deve ser preenchido. ")
        String year,
        @NotBlank(message = "O campo color deve ser preenchido. ")
        String color,
        @NotNull(message = "O campo km deve ser preenchido. ")
        Integer km,
        @NotBlank(message = "O campo imageUrl deve ser preenchido. ")
        String imageUrl,
        @NotBlank(message = "O campo carType deve ser preenchido. ")
        String carType,
        @NotNull(message = "O campo price deve ser preenchido. ")
        Double price,
        @Nullable
        Double power,
        @Nullable
        Integer numberOfPassengers,
        @Nullable
        Double fuelConsumption,
        @Nullable
        String trunkCapacity) {
}
