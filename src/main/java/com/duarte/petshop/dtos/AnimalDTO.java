package com.duarte.petshop.dtos;

import java.time.LocalDate;

import com.duarte.petshop.enums.Species;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AnimalDTO(
		@NotBlank String name,
		@NotNull LocalDate dateOfBirth,
		@Enumerated(EnumType.STRING) Species specie,
		@NotNull Long idOwner){
}
