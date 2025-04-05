package com.duarte.petshop.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.duarte.petshop.dtos.AppointmentDTO;
import com.duarte.petshop.model.Appointment;
import com.duarte.petshop.service.AppointmentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {
	
	private final AppointmentService appointmentService;
	
	@PostMapping
	public ResponseEntity<String> saveAppointment(@RequestBody @Valid AppointmentDTO dto){
		
		appointmentService.saveAppointment(dto);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body("Appointment scheduled successfully!");
		
	}
	
	@GetMapping
	public ResponseEntity<List<Appointment>> getAllAppointments(){
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(appointmentService.getAllAppointments());
	}

	@DeleteMapping
	public ResponseEntity<String> cancelAppointment(@PathVariable Long id){

		appointmentService.cancelAppointment(id);

		return ResponseEntity.status(HttpStatus.OK)
				.body("Appointment successfully cancelled.");
	}
}
