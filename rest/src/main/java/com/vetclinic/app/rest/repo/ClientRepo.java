package com.vetclinic.app.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vetclinic.app.rest.models.Client;

public interface ClientRepo extends JpaRepository<Client, Integer> {
    
}
