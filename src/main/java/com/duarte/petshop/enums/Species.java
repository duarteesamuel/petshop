package com.duarte.petshop.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Species {
	
	CANIDEOS("Canídeo"),
	FELINES("Felino"),
	BIRDS("Pássaro"),
	FISH("Peixe"),
	REPTILES("Réptil"),
	RODENTS("Roedores");
	
	private final String specie;
	
	public String getSpecie() {
		return specie;
	}
	
}
