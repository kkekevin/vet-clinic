package com.vetclinic.app.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vetclinic.app.rest.models.Veterinarian;

public interface VetRepo extends JpaRepository<Veterinarian, Integer> {

}
