package com.duarte.petshop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.duarte.petshop.exception.MultipleConflictException;
import com.duarte.petshop.exception.PetshopDataNotFound;
import org.springframework.stereotype.Service;

import com.duarte.petshop.dtos.PetOwnerDTO;
import com.duarte.petshop.model.PetOwner;
import com.duarte.petshop.repository.PetOwnerRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PetOwnerService {

	private final PetOwnerRepository ownerRepository;
	
	@Transactional
	public void savePetOwner(PetOwnerDTO dto) {

		List<String> errors = new ArrayList<>();

		if(ownerRepository.existsByCpf(dto.cpf())){
			errors.add("This CPF is already registered.");
		}
		if(ownerRepository.existsByEmail(dto.email())){
			errors.add("This e-mail is already registered.");
		}
		if(ownerRepository.existsByTelephone(dto.telephone())){
			errors.add("This telephone is already registered.");
		}

		if(!errors.isEmpty()){
			throw new MultipleConflictException(errors);
		}

		PetOwner owner = PetOwner.builder()
						 .name(dto.name())
						 .email(dto.email())
						 .cpf(dto.cpf())
						 .address(dto.address())
						 .telephone(dto.telephone())
						 .build();

		ownerRepository.save(owner);
	}


	public List<PetOwner> getAllOwners(){

		return Optional.of(ownerRepository.findAll())
				.filter(owners -> !owners.isEmpty())
				.orElseThrow(() -> new PetshopDataNotFound("No records found in the system"));
	}
}
