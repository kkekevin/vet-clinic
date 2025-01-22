package com.vetclinic.app.rest.models;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "consultas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Consultation {
    @Id
    @Column (nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consultas_seq")
    @SequenceGenerator(name = "consultas_seq", sequenceName = "consultas_seq", allocationSize = 1)
    private int cod_consulta;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "crmv", nullable = false)
    private Veterinarian veterinarian;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_animal", nullable = false)
    private Pet pet;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_recepcionista", nullable = false)
    private Attendant attendant;

    @Column (nullable = false)
    private float valor;

    @Column (nullable = false, length = 20)
    private Date data_consulta;

    @Column (nullable = false)
    private Time hora_consulta;

    public Consultation (Veterinarian veterinarian, Pet pet, Attendant attendant) {
        this.attendant = attendant;
        this.veterinarian = veterinarian;
        this.pet = pet;
    }
}
