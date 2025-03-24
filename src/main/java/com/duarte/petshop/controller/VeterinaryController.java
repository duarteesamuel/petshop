package com.duarte.petshop.controller;

import com.duarte.petshop.service.VeterinaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/veterinarians")
@RequiredArgsConstructor
public class VeterinaryController {

    private final VeterinaryService veterinaryService;

    
}
