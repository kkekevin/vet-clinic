package com.vetclinic.app.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vetclinic.app.rest.models.Attendant;

public interface AttendRepo extends JpaRepository<Attendant, Integer> {
    
}
