package com.duarte.petshop.service;

import java.util.List;
import java.util.Optional;

import com.duarte.petshop.exception.PetshopDataNotFound;
import org.springframework.stereotype.Service;

import com.duarte.petshop.dtos.AppointmentDTO;
import com.duarte.petshop.model.Animal;
import com.duarte.petshop.model.Appointment;
import com.duarte.petshop.repository.AnimalRepository;
import com.duarte.petshop.repository.AppointmentRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentService {
	
	private final AppointmentRepository appointmentRepository;
	private final AnimalRepository animalRepository;
	
	@Transactional
	public void saveAppointment(AppointmentDTO dto) {
		Animal animal = animalRepository.findById(dto.idAnimal()).orElseThrow();
		
		
		Appointment appointment = Appointment.builder()
								  .date(dto.date())
								  .time(dto.time())
								  .description(dto.description())
								  .animal(animal)
								  .build();
		
		appointmentRepository.save(appointment);
		
	}
	
	public List<Appointment> getAllAppointments(){

		return Optional.of(appointmentRepository.findAll())
				.filter(appointments -> !appointments.isEmpty())
				.orElseThrow(() -> new PetshopDataNotFound("No veterinary consultations found in the system."));
	}

}
