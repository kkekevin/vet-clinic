package com.vetclinic.app.rest.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "empregados")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @Column (nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empregados_seq")
    @SequenceGenerator(name = "empregados_seq", sequenceName = "empregados_seq", allocationSize = 1)
    private int id_empregado;

    @Column (nullable = false, unique = true)
    private int cpf;

    @Column (nullable = false)
    private String nome;

    @Column (length = 100)
    private String logradouro;
    
    @Column (length = 60, nullable = false)
    private String cidade;
    
    @Column(length = 2, nullable = false)
    private String uf;
    
    @Column(length = 40)
    private String bairro;
    
    @Column(length = 9)
    private String cep;
    
    @Column(length = 60)
    private String email;

    @Column(length = 15)
    private String telefone;

    @JsonManagedReference
    @OneToOne(mappedBy = "employee", orphanRemoval = true, fetch = FetchType.LAZY)
    private Attendant attendant;

    @JsonManagedReference
    @OneToOne(mappedBy = "employee", orphanRemoval = true, fetch = FetchType.LAZY)
    private Veterinarian veterinarian;

}
