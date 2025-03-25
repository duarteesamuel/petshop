package com.duarte.petshop.controller;

import com.duarte.petshop.dtos.VeterinaryDTO;
import com.duarte.petshop.model.Veterinary;
import com.duarte.petshop.service.VeterinaryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/veterinarians")
@RequiredArgsConstructor
public class VeterinaryController {

    private final VeterinaryService veterinaryService;

    @PostMapping
    public ResponseEntity<String> saveVeterinary(@RequestBody @Valid VeterinaryDTO dto){

        veterinaryService.saveVeterinary(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Veterinary registered successfully!");
    }

    @GetMapping
    public ResponseEntity<List<Veterinary>> getAllVeterinarians(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(veterinaryService.getAllVeterinarians());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veterinary> getVeterinaryById(@PathVariable Long id){

        return ResponseEntity.status(HttpStatus.OK)
                .body(veterinaryService.findVeterinaryById(id));
    }
}
