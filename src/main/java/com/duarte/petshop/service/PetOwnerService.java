package com.duarte.petshop.service;

import java.util.List;

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
		
		return ownerRepository.findAll();
	}
}
