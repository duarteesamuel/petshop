package com.duarte.petshop.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AppointmentDTO(
		@NotNull LocalDate date,
		@NotNull LocalTime time,
		@NotBlank String description,
		Long idAnimal) {

}
