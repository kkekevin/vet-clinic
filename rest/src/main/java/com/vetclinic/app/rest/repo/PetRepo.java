package com.vetclinic.app.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vetclinic.app.rest.models.Pet;

public interface PetRepo extends JpaRepository<Pet, Integer> {
    
}
