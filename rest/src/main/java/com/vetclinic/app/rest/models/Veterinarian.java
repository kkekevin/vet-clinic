package com.vetclinic.app.rest.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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

    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_empregado", nullable = false)
    private Employee employee;

    @OneToMany(mappedBy = "veterinarian", fetch = FetchType.LAZY)
    private List<Consultation> consultations;

    public Veterinarian (Employee employee) {
        this.employee = employee;
    }
}
