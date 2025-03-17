package com.duarte.petshop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duarte.petshop.dtos.AnimalDTO;
import com.duarte.petshop.service.AnimalService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/animals")
@RequiredArgsConstructor
public class AnimalController {

	private final AnimalService animalService;
	
	public ResponseEntity<String> saveAnimal(@RequestBody @Valid AnimalDTO dto){
		
		animalService.saveAnimal(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body("Animal registered successfully!");
	}
}
