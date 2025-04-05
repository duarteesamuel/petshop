package com.duarte.petshop.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import com.duarte.petshop.model.Veterinary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duarte.petshop.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

    long countByVeterinaryAndDate(Veterinary veterinary, LocalDate date);

}
