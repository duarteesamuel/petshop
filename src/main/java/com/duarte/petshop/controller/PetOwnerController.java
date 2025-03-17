package com.duarte.petshop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duarte.petshop.dtos.PetOwnerDTO;
import com.duarte.petshop.model.PetOwner;
import com.duarte.petshop.service.PetOwnerService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/owners")
@RequiredArgsConstructor
public class PetOwnerController {
	
	private final PetOwnerService ownerService;
	
	@PostMapping
	public ResponseEntity<String> savePetOwner(@RequestBody @Valid PetOwnerDTO dto){
		ownerService.savePetOwner(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body("Pet owner registered successfully!");
	}
	
	@GetMapping
	public ResponseEntity<List<PetOwner>> getAllOwners(){
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(ownerService.getAllOwners());
		
	}
}
