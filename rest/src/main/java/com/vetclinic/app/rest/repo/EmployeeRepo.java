package com.vetclinic.app.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vetclinic.app.rest.models.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    
}
