package com.vetclinic.app.rest.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "medicos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Veterinarian {
    @Id
    private int crmv;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_empregado", nullable = false)
    private Employee employee;

    public Veterinarian (Employee employee) {
        this.employee = employee;
    }
}
