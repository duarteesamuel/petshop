package com.duarte.petshop.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.duarte.petshop.enums.AppointmentStatus;
import com.duarte.petshop.exception.PetshopDataNotFound;
import com.duarte.petshop.exception.PetshopException;
import com.duarte.petshop.model.Veterinary;
import com.duarte.petshop.repository.VeterinaryRepository;
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
	private final VeterinaryRepository veterinaryRepository;
	
	@Transactional
	public void saveAppointment(AppointmentDTO dto) {

		Animal animal = animalRepository.findById(dto.idAnimal())
													.orElseThrow(
															() -> new PetshopDataNotFound("Animal with id " + dto.idAnimal() + " not found.")
													);

		Veterinary veterinary = veterinaryRepository.findById(dto.idVeterinary())
													.orElseThrow(() -> new PetshopDataNotFound("Veterinary with id " + dto.idVeterinary() + " not found."));


		LocalDate appointmentDate = dto.date();
		long scheduledAppointments = appointmentRepository.countByVeterinaryAndDate(veterinary, appointmentDate);

		if(scheduledAppointments > 3){
			throw new PetshopException("The Veterinarian with the id " + dto.idVeterinary() + " reached the maximum number of 3 consultations for the day.");
		}

		Appointment appointment = Appointment.builder()
				.date(dto.date())
				.description(dto.description())
				.animal(animal)
				.veterinary(veterinary)
				.status(AppointmentStatus.SCHEDULED)
				.build();

		veterinary.getAppointments().add(appointment);

		animal.getAppointmentPet().add(appointment);
		animal.setNumberOfAppointments(animal.getAppointmentPet().size());
		
		appointmentRepository.save(appointment);
		animalRepository.save(animal);
	}
	
	public List<Appointment> getAllAppointments(){

		return Optional.of(appointmentRepository.findAll())
				.filter(appointments -> !appointments.isEmpty())
				.orElseThrow(() -> new PetshopDataNotFound("No veterinary consultations found in the system."));
	}

}
