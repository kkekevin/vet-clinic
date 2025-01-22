package com.vetclinic.app.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vetclinic.app.rest.models.Consultation;
import com.vetclinic.app.rest.repo.AttendRepo;
import com.vetclinic.app.rest.repo.ConsultRepo;
import com.vetclinic.app.rest.repo.PetRepo;
import com.vetclinic.app.rest.repo.VetRepo;

@RestController
public class ConsultationController {
    @Autowired
    ConsultRepo consultRepo;
    @Autowired
    VetRepo vetRepo;
    @Autowired
    PetRepo petRepo;
    @Autowired
    AttendRepo attendRepo;

    @PostMapping(value = "consult/save")
    public ResponseEntity<Consultation> consultPet(@RequestBody Consultation consultation) {
        try {
            Consultation newConsult = new Consultation(vetRepo.findById(consultation.getVeterinarian().getCrmv()).get(),
                    petRepo.findById(consultation.getPet().getCod_animal()).get(),
                    attendRepo.findById(consultation.getAttendant().getCod_recepcionista()).get());

            newConsult.setValor(consultation.getValor());
            newConsult.setData_consulta(consultation.getData_consulta());
            newConsult.setHora_consulta(consultation.getHora_consulta());
            consultRepo.save(newConsult);
    
            return ResponseEntity.status(HttpStatus.CREATED).body(consultation);            
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "consult/{id}/update")
    public ResponseEntity<String> updateValue(@PathVariable int id, @RequestBody Consultation consultation) {
        Consultation updatedConsult = consultRepo.findById(id).get();

        if (updatedConsult == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("null");

        updatedConsult.setValor(consultation.getValor());
        consultRepo.save(updatedConsult);
        return ResponseEntity.status(HttpStatus.OK).body("...updated");
    }

}
