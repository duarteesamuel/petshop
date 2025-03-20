package com.duarte.petshop.service;

import java.util.List;

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
				.orElseThrow(() -> new RuntimeException("PetOwner with id " + dto.idOwner() + " not found!"));
		
		Animal animal = Animal.builder()
						.name(dto.name())
						.dateOfBirth(dto.dateOfBirth())
						.specie(dto.specie())
						.petOwner(owner)
						.build();

		owner.getAnimals().add(animal);

		owner.updateNumbersOfPet();

		animalRepository.save(animal);
		ownerRepository.save(owner);
	}
	
	public List<Animal> getAllAnimals(){
		return animalRepository.findAll();
	}
}
