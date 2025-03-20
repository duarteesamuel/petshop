package com.duarte.petshop.model;

import java.time.LocalDate;

import com.duarte.petshop.enums.Species;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "animals")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "animal_id")
	private Long id;
	
	@NotBlank(message = "The pet's name must not be empty.")
	private String name;
	
	@Column(name = "date_of_birth")
	@NotNull(message = "The pet's date of birth is required.")
	@Past(message = "The pet's date of birth must be in the past.")
	private LocalDate dateOfBirth;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "The pet's specie must not be nullw.")
	private Species specie;
	
	@ManyToOne
	@JoinColumn(name = "owner_id", nullable = false)
	@NotNull(message = "The pet must have an owner.")
	@JsonIgnore
	private PetOwner petOwner;
}
