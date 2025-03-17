package com.duarte.petshop.service;

import org.springframework.stereotype.Service;

import com.duarte.petshop.dtos.PetOwnerDTO;
import com.duarte.petshop.repository.PetOwnerRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PetOwnerService {

	private final PetOwnerRepository repository;
	
	@Transactional
	public void savePetOwner(PetOwnerDTO dto) {
		
	}
}
