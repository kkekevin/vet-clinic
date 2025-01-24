package com.vetclinic.app.rest.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "invoice")
@NoArgsConstructor
public class Invoice {
    @Id
    @Column (nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_seq")
    @SequenceGenerator(name = "invoice_seq", sequenceName = "invoice_seq", allocationSize = 1)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "consult_id", nullable = false)
    private Consultation consultation;

    @Column(nullable = false)
    private long total;

    public Invoice (Consultation consultation) {
        this.consultation = consultation;
    }
}
