package com.fiap.amaralrentcar.dtos;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import lombok.Builder;

@Builder
public record ClientDto(@Email String email, @Nullable String name) {
}
