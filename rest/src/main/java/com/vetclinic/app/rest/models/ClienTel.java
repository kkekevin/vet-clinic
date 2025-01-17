package com.vetclinic.app.rest.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cliente_tel")
@Setter
@Getter
public class ClienTel {
    @Id
    @Column (nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_tel_seq")
    @SequenceGenerator(name = "cliente_tel_seq", sequenceName = "cliente_tel_seq", allocationSize = 1)
    private int id_tel;
    
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cpf", nullable = false)
    private Client client;
    
    @Column(name = "telefone")
    private String telefone;

    public ClienTel (Client client) {
        this.client = client;
    }

    public ClienTel () {}
}
