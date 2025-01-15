package com.vetclinic.app.rest.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vetclinic.app.rest.models.Client;
import com.vetclinic.app.rest.models.Pet;
import com.vetclinic.app.rest.repo.ClientRepo;
import com.vetclinic.app.rest.repo.PetRepo;

@RestController
public class PetController {
    @Autowired
    private PetRepo petRepo;
    @Autowired
    private ClientRepo clientRepo;

    @GetMapping(value = "/pet")
    public ResponseEntity<List<Pet>> getAllPets () {
        try {
            List<Pet> petList = petRepo.findAll();

            if (petList.isEmpty()) 
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(petList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/pet/{cpf}/save")
    public ResponseEntity<String> addPet (@PathVariable String cpf, @RequestBody Pet pet) {
        Client client = clientRepo.findById(cpf).get();
        if (client == null)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("not found");

        Pet newPet = new Pet(client);
        newPet.setNome(pet.getNome());
        newPet.setData_nascimento(pet.getData_nascimento());
        newPet.setTipo(pet.getTipo());
        newPet.setRaca(pet.getRaca());
        petRepo.save(newPet);
        return ResponseEntity.status(HttpStatus.CREATED).body("...pet created");
    }

    @DeleteMapping(value = "/pet/{cpf}/delete")
    public ResponseEntity<String> deletePet (@PathVariable String cpf, @RequestBody Pet name) {
        System.out.println(cpf + " " + name.getNome());
        petRepo.deletePetByName(cpf, name.getNome());
        // return deletedPet != null ? new ResponseEntity<>(deletedPet, HttpStatus.OK)
        //                         : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        return new ResponseEntity<>("deleted...", HttpStatus.OK);
    }

    @GetMapping(value = "pet/{cpf}")
    public ResponseEntity<List<Pet>> getPetByClient (@PathVariable String cpf) {
        try {
            Client client = clientRepo.findById(cpf).get();
            System.out.println(client);
            List<Pet> petList = petRepo.findAll().stream()
                                .filter(pet -> pet.getClient().equals(client))
                                .collect(Collectors.toList());
            System.out.println(petList);

            if (petList.isEmpty()) 
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(petList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
