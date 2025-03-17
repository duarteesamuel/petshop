package com.duarte.petshop.service;

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
}
