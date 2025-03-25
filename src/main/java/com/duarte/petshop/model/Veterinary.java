package com.duarte.petshop.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "veterinarians")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Veterinary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "veterinary_id")
    private Long id;

    @NotBlank(message = "The veterinary's name must not be empty.")
    private String name;

    @NotBlank(message = "The veterinary's email must not be empty.")
    @Email(message = "This is not a valid email address. Please provide an email in the format example@domain.com.")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Veterinary CRMV cannot be empty.")
    @Pattern(regexp = "\\d{6}/[A-Z]{2}", message = "CRMV must be in the format 123456/RJ")
    @Column(unique = true)
    private String crmv;

    @OneToMany(mappedBy = "veterinary", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Appointment> appointments = new ArrayList<>();

}
