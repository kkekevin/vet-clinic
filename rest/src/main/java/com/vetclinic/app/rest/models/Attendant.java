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
@Table(name = "recepcionistas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Attendant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cod_recepcionista;

    private int id_empregado;

}
