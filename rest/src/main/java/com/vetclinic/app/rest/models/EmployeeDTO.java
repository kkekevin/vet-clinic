package com.vetclinic.app.rest.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private int id_empregado;

    private int cpf;

    private String nome;

    private String logradouro;
    
    private String cidade;
    
    private String uf;
    
    private String bairro;
    
    private String cep;
    
    private String email;

    private String telefone;

    private int crmv;

}
