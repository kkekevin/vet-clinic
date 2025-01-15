package com.vetclinic.app.rest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "medicos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Veterinarian {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int crmv;

    private int id_empregado;

}
