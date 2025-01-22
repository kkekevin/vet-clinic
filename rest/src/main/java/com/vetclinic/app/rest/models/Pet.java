package com.vetclinic.app.rest.models;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq")
    @SequenceGenerator(name = "pet_seq", sequenceName = "pet_seq", allocationSize = 1)
    private int cod_animal;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cpf", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "pet", fetch = FetchType.LAZY)
    List<Consultation> consultations;
    
    @Column(nullable = false, length = 30)
    private String nome;

    @Column(length = 20)
    private Date data_nascimento;

    @Column(nullable = false, length = 15)
    private String raca;

    @Column(nullable = false, length = 15)
    private String tipo;

    public Pet (Client client) {
        this.client = client;
    }
    
}
