package com.duarte.petshop.service;

import org.springframework.stereotype.Service;

import com.duarte.petshop.dtos.AnimalDTO;
import com.duarte.petshop.model.Animal;
import com.duarte.petshop.model.PetOwner;
import com.duarte.petshop.repository.AnimalRepository;
import com.duarte.petshop.repository.PetOwnerRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnimalService {
	
	private final AnimalRepository animalRepository;
	private final PetOwnerRepository ownerRepository;
	
	@Transactional
	public void saveAnimal(AnimalDTO dto) {
		
		PetOwner owner = ownerRepository.findById(dto.idOwner())
				.orElseThrow();
		
		Animal animal = Animal.builder()
						.name(dto.name())
						.dateOfBirth(dto.dateOfBirth())
						.specie(dto.specie())
						.petOwner(owner)
						.build();
		
		animalRepository.save(animal);
	}
}
