package com.vetclinic.app.rest.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recepcionistas_seq")
    @SequenceGenerator(name = "recepcionistas_seq", sequenceName = "recepcionistas_seq", allocationSize = 1)
    private int cod_recepcionista;

    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_empregado", nullable = false)
    private Employee employee;

    public Attendant (Employee employee) {
        this.employee = employee;
    }

}
