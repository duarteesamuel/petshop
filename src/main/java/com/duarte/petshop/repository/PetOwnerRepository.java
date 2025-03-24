package com.duarte.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duarte.petshop.model.PetOwner;

@Repository
public interface PetOwnerRepository extends JpaRepository<PetOwner, Long>{

    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
    boolean existsByTelephone(String telephone);
}
