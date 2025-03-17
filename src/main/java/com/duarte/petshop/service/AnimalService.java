package com.duarte.petshop.service;

import org.springframework.stereotype.Service;

import com.duarte.petshop.dtos.AnimalDTO;
import com.duarte.petshop.repository.AnimalRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnimalService {
	
	private final AnimalRepository repository;
	
	@Transactional
	public void saveAnimal(AnimalDTO dto) {
		
	}
}
