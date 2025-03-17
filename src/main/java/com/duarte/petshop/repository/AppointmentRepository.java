package com.duarte.petshop.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duarte.petshop.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, UUID>{

}
