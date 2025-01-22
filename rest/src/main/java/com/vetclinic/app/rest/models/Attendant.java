package com.vetclinic.app.rest.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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

    @OneToMany(mappedBy = "attendant", fetch = FetchType.LAZY)
    private List<Consultation> consultations;
    
    public Attendant (Employee employee) {
        this.employee = employee;
    }

}
