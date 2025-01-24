package com.vetclinic.app.rest.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "exame_resultados")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ExamResult {
    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exame_resultados_seq")
    @SequenceGenerator(name = "exame_resultados_seq", sequenceName = "exame_resultados_seq", allocationSize = 1)
    private int id;

    @ManyToOne
    @JoinColumn(name = "cod_exame")
    private Examination examination;

    @ManyToOne
    @JoinColumn(name = "cod_consulta")
    private Consultation consultation;

    private String resultado;

    public ExamResult(Consultation consultation) {
        this.consultation = consultation;
    }
}
