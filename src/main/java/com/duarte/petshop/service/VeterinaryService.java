package com.duarte.petshop.service;

import com.duarte.petshop.repository.VeterinaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VeterinaryService {

    private final VeterinaryRepository veterinaryRepository;

}
