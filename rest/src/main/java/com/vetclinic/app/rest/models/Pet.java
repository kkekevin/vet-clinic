package com.vetclinic.app.rest.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pet")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pet {
    @Id
    @Column(unique = true, nullable = false)
    private int cod_animal;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cpf", nullable = false)
    private Client client;

    @Column(nullable = false, length = 30)
    private String nome;

    @Column(nullable = false)
    private String data_nascimento;

    @Column(nullable = false)
    private String raca;

    @Column(nullable = false)
    private String tipo;
    
}
