package com.duarte.petshop.service;

import com.duarte.petshop.dtos.VeterinaryDTO;
import com.duarte.petshop.exception.MultipleConflictException;
import com.duarte.petshop.exception.PetshopDataNotFound;
import com.duarte.petshop.model.Veterinary;
import com.duarte.petshop.repository.VeterinaryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VeterinaryService {

    private final VeterinaryRepository veterinaryRepository;

    @Transactional
    public void saveVeterinary(VeterinaryDTO dto){

        List<String> errors = new ArrayList<>();

        if(veterinaryRepository.existsByCrmv(dto.crmv())){
            errors.add("This CRMV already registered.");
        }

        if(veterinaryRepository.existsByEmail(dto.email())){
            errors.add("This e-mail already registered.");
        }

        if(!errors.isEmpty()){
            throw new MultipleConflictException(errors);
        }

        Veterinary veterinary = Veterinary.builder()
                .name(dto.name())
                .email(dto.email())
                .crmv(dto.crmv())
                .build();

        veterinaryRepository.save(veterinary);
    }

    public List<Veterinary> getAllVeterinarians(){

        return Optional.of(veterinaryRepository.findAll())
                .filter(veterinarians -> !veterinarians.isEmpty())
                .orElseThrow(() -> new PetshopDataNotFound("No veterinarian registered in the system."));
    }

    public Veterinary findVeterinaryById(Long id){

        return veterinaryRepository.findById(id)
                .orElseThrow(() -> new PetshopDataNotFound("Veterinary with id "+ id + " not found."));
    }
}
