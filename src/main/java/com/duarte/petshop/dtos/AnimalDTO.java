package com.duarte.petshop.dtos;

import java.time.LocalDate;

import com.duarte.petshop.enums.Species;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AnimalDTO(
		@NotBlank String name,
		@NotNull @JsonFormat(pattern = "dd/MM/yyyy") LocalDate dateOfBirth,
		@Enumerated(EnumType.STRING) Species specie,
		@NotNull Long idOwner){
}
