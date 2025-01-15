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
@Table (name = "empregados")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @Column (nullable = false, unique = true)
    @GeneratedValue
    private int id_empregado;

    @Column (nullable = false)
    private int cpf;

    @Column (nullable = false)
    private String nome;

    @Column (length = 100)
    String logradouro;
    
    @Column (length = 60, nullable = false)
    String cidade;
    
    @Column(length = 2, nullable = false)
    String uf;
    
    @Column(length = 40)
    String bairro;
    
    @Column(length = 9)
    String cep;
    
    @Column(length = 60)
    String email;

}
