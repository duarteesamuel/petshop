package com.duarte.petshop.service;

import org.springframework.stereotype.Service;

import com.duarte.petshop.repository.AppointmentRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentService {
	
	private final AppointmentRepository repository;
	
	@Transactional
	public void saveAppointment() {
		
	}
}
