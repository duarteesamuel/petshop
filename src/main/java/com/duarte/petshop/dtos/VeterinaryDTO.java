package com.duarte.petshop.dtos;

import jakarta.validation.constraints.NotBlank;

public record VeterinaryDTO(@NotBlank String name,
                            @NotBlank String email,
                            @NotBlank String crmv) {
}
