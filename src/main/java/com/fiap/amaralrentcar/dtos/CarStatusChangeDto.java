package com.fiap.amaralrentcar.dtos;

import com.fiap.amaralrentcar.entity.StatusEnum;
import jakarta.validation.constraints.NotBlank;

public record CarStatusChangeDto(@NotBlank StatusEnum status) {
}
