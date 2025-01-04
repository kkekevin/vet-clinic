package com.vetclinic.app.rest.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client {
    @Id
    @Column (unique = true, nullable = false)
    private int cpf;

    @Column (nullable = false, length = 100)
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

    @OneToMany(mappedBy = "client", orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<ClienTel> telefone;

    @OneToMany(mappedBy = "client", orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Pet> pets;
}
