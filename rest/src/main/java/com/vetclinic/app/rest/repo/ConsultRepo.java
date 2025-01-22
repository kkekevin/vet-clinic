package com.vetclinic.app.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vetclinic.app.rest.models.Consultation;

public interface ConsultRepo extends JpaRepository<Consultation, Integer>{
    
}
