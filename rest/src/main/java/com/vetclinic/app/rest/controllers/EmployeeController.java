package com.vetclinic.app.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vetclinic.app.rest.models.Attendant;
import com.vetclinic.app.rest.models.Employee;
import com.vetclinic.app.rest.models.EmployeeDTO;
import com.vetclinic.app.rest.models.Veterinarian;
import com.vetclinic.app.rest.repo.AttendRepo;
import com.vetclinic.app.rest.repo.EmployeeRepo;
import com.vetclinic.app.rest.repo.VetRepo;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    VetRepo vetRepo;
    @Autowired
    AttendRepo attendRepo;

    @PostMapping(value = "/employee/vet/save")
    public ResponseEntity<Veterinarian> hireVeterinarian (@RequestBody EmployeeDTO employeeDTO) {
        Employee newEmployee = new Employee();
        newEmployee.setNome(employeeDTO.getNome());
        newEmployee.setBairro(employeeDTO.getBairro());
        newEmployee.setCep(employeeDTO.getCep());
        newEmployee.setCidade(employeeDTO.getCidade());
        newEmployee.setCpf(employeeDTO.getCpf());
        newEmployee.setEmail(employeeDTO.getEmail());
        newEmployee.setLogradouro(employeeDTO.getLogradouro());
        newEmployee.setTelefone(employeeDTO.getTelefone());
        newEmployee.setUf(employeeDTO.getUf());

        Veterinarian newVet = new Veterinarian(employeeRepo.save(newEmployee));
        
        newVet.setCrmv(employeeDTO.getCrmv());
        vetRepo.save(newVet);
        return new ResponseEntity<>(newVet, HttpStatus.CREATED);
    }

    @PostMapping(value = "/employee/attendant/save")
    public ResponseEntity<Attendant> hireAttendant (@RequestBody EmployeeDTO employeeDTO) {
        Employee newEmployee = new Employee();
        newEmployee.setNome(employeeDTO.getNome());
        newEmployee.setBairro(employeeDTO.getBairro());
        newEmployee.setCep(employeeDTO.getCep());
        newEmployee.setCidade(employeeDTO.getCidade());
        newEmployee.setCpf(employeeDTO.getCpf());
        newEmployee.setEmail(employeeDTO.getEmail());
        newEmployee.setLogradouro(employeeDTO.getLogradouro());
        newEmployee.setTelefone(employeeDTO.getTelefone());
        newEmployee.setUf(employeeDTO.getUf());

        Attendant newAttendant = new Attendant(employeeRepo.save(newEmployee));
        
        attendRepo.save(newAttendant);
        return new ResponseEntity<>(newAttendant, HttpStatus.CREATED);
    }

    @PutMapping(value = "/employee/update/{id}")
    public ResponseEntity<String> updateContact (@PathVariable int id, @RequestBody Employee employee) {
        Employee updateEmployee = employeeRepo.findById(id).get();
        if (updateEmployee != null) {
            updateEmployee.setTelefone(employee.getTelefone());
            employeeRepo.save(updateEmployee);
            return new ResponseEntity<>("...updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("...not found", HttpStatus.NOT_FOUND);        
    }

    @DeleteMapping(value = "/employee/delete/{id}")
    public ResponseEntity<Employee> fireEmployee (@PathVariable int id) {
        Employee firedEmployee = employeeRepo.findById(id).get();
        if (firedEmployee != null) {
            employeeRepo.delete(firedEmployee);
            return new ResponseEntity<>(firedEmployee, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
