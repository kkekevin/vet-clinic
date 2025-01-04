package com.vetclinic.app.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vetclinic.app.rest.models.ClienTel;

public interface ClienTelRepo extends JpaRepository<ClienTel, Integer> {
    
}
