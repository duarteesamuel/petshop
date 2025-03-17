package com.duarte.petshop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
