package com.duarte.petshop.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AppointmentDTO(
		@NotNull @JsonFormat(pattern = "dd/MM/yyyy") LocalDate date,
		@NotBlank String description,
		@NotNull Long idAnimal,
		@NotNull Long idVeterinary) {

}
