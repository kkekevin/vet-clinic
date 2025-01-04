package com.vetclinic.app.rest.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cliente_tel")
@Setter
@Getter
public class ClienTel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_tel;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cpf", nullable = false)
    private Client client;
    
    @Column(name = "telefone")
    private int telefone;

    public ClienTel (Client client) {
        this.client = client;
    }

    public ClienTel () {}
}
