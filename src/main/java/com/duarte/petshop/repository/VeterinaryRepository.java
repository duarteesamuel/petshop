package com.duarte.petshop.repository;

import com.duarte.petshop.model.Veterinary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinaryRepository extends JpaRepository<Veterinary, Long> {
    boolean existsByCrmv(String crmv);
    boolean existsByEmail(String crmv);
}
