package com.vetclinic.app.rest.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "consulta")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Consultation {
    @Id
    @Column (nullable = false, unique = true)
    @GeneratedValue
    private int cod_consulta;

    @Column (nullable = false)
    private int crmv;

    @Column (nullable = false)
    private int cod_animal;

    @Column (nullable = false)
    private int cod_recepcionista;

    @Column (nullable = false)
    private float valor;

    @Column (nullable = false)
    private String data_consulta;

    @Column (nullable = false)
    private String hora_consulta;
}
