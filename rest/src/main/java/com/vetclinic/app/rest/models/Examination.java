package com.vetclinic.app.rest.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "exames")
@Getter
public class Examination {
    @Id
    @Column(nullable = false, unique = true)
    private int cod_exame;

    @Column(nullable = false, length = 60)
    private String nome;

    @OneToMany(mappedBy = "examination")
    Set<ExamResult> examResults;
    
    private long valor;    

}
