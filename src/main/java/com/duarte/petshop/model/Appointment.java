package com.duarte.petshop.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
	private Animal animal;
	
	@NotNull(message = "The appointment's date is required.")
	@Column(name = "appointment_date", nullable = false)
	private LocalDate date;
	
	@NotNull(message = "The appointment's time is required.")
	@Column(name = "appointment_time", nullable = false)
	private LocalTime time;
	
	@NotBlank(message = "The appointment's reason is required.")
	@Size(max = 300, message = "The appoiment's description should not pass 300 characteres.")
	private String description;
	
}
