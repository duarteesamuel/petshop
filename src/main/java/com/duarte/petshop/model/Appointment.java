package com.duarte.petshop.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import com.duarte.petshop.enums.AppointmentStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "appointments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "appointment_id", nullable = false)
	private UUID id;
	
	@ManyToOne
	@JoinColumn(name = "animal_id", nullable = false)
	@NotNull(message = "The appointment have must an animal")
	@JsonBackReference("animal-appointments")
	private Animal animal;

	@ManyToOne
	@JoinColumn(name = "veterinary_id", nullable = false)
	@NotNull(message = "The appointment have must an veterinary")
	@JsonBackReference("veterinary-appointments")
	private Veterinary veterinary;
	
	@NotNull(message = "The appointment's date is required.")
	@FutureOrPresent(message = "the date of the appointment must be in the present or future.")
	@Column(name = "appointment_date", nullable = false)
	private LocalDate date;
	
	@NotBlank(message = "The appointment's reason is required.")
	@Size(max = 300, message = "The appointment's description should not pass 300 characteres.")
	private String description;

	@Enumerated(EnumType.STRING)
	private AppointmentStatus status;
}
