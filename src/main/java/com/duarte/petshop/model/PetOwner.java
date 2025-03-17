package com.duarte.petshop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pet_owner")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PetOwner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "owner_id")
	private Long id;
	
	@NotBlank(message = "The pet owner's name must not be empty.")
	private String name;
	
	@NotBlank(message = "The pet owner's email must not be empty.")
	@Email(message = "This is not a valid email address. Please provide an email in the format example@domain.com.")
	@Column(unique = true)
	private String email;
	
	@NotBlank(message = "The pet owner's CPF must not be empty.")
	@Size(min = 11, max = 11, message = "Invalid cpf number. use format 123xxxxxxxx.")
	@Column(unique = true)
	private String cpf;
	
	@NotBlank(message = "The pet owner's address must not be empty.")
	private String address;
	
	@NotBlank(message = "The pet owner's telephone must not be empty.")
	@Column(unique = true)
	@Size(min = 11, max = 11, message = "Invalid phone number. Use format 21xxxxxxxxx.")
	private String telephone;
	
}
