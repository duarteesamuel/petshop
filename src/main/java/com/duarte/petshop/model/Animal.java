package com.duarte.petshop.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.duarte.petshop.enums.Species;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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
	@NotNull(message = "The pet's specie must not be null.")
	private Species specie;
	
	@ManyToOne
	@JoinColumn(name = "owner_id", nullable = false)
	@NotNull(message = "The pet must have an owner.")
	@JsonIgnore
	private PetOwner petOwner;

	@OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference("animal-appointments")
	private List<Appointment> appointmentPet = new ArrayList<>();

	private Integer numberOfAppointments;
}
