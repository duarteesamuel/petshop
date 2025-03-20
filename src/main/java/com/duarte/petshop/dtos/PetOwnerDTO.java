package com.duarte.petshop.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PetOwnerDTO(
		@NotBlank String name,
		@NotBlank String email,
		@NotBlank String cpf,
		@NotBlank String address,
		@NotBlank String telephone
	)
{}
