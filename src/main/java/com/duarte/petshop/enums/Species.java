package com.duarte.petshop.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public enum Species {

	CANIDEO("Canídeo"),
	FELINE("Felino"),
	BIRD("Pássaro"),
	FISH("Peixe"),
	REPTILE("Réptil"),
	RODENT("Roedor");

	private String specie;

	Species(String specie){
		this.specie = specie;
	}

	public String getSpecie(){
		return specie;
	}
}
