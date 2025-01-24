package com.vetclinic.app.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vetclinic.app.rest.models.ExamResult;

public interface ExamRepo extends JpaRepository<ExamResult, Integer> {
    
}
