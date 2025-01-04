package com.vetclinic.app.rest.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vetclinic.app.rest.models.ClienTel;
import com.vetclinic.app.rest.models.Client;
import com.vetclinic.app.rest.repo.ClienTelRepo;
import com.vetclinic.app.rest.repo.ClientRepo;


@RestController
public class ClientController {
    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private ClienTelRepo clienTelRepo;

    @GetMapping(value = "/client")
    public ResponseEntity<List<Client>> getAllClient () {
        try {
            List<Client> clientList = new ArrayList<>();
            clientRepo.findAll().forEach(clientList::add);

            if (clientList.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(clientList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/client/{cpf}")
    public ResponseEntity<Client> getClient (@PathVariable int cpf) {
        Optional<Client> client = clientRepo.findById(cpf);

        if (client.isPresent())
            return new ResponseEntity<>(client.get(), HttpStatus.OK);
        return new ResponseEntity<>(client.get(), HttpStatus.NOT_FOUND);
    }
    
    @PostMapping(value = "/save")
    public String createClient (@RequestBody Client client) {
        //Set<ClienTel> clienTels = client.getTelefone();
        // clienTel.setClient(client);
        clientRepo.save(client);
        for (ClienTel i : client.getTelefone()) {
            ClienTel clienTel = new ClienTel(client);
            System.out.println("telefone: " + i.getTelefone());
            clienTel.setTelefone(i.getTelefone());
            clienTelRepo.save(clienTel);
        }

        return "...saved";
    }

    @PutMapping(value = "/update/{cpf}")
    public String updateClient (@PathVariable int cpf, @RequestBody Client client) {
        Client updatedClient = clientRepo.findById(cpf).get();
        updatedClient.setNome(client.getNome());
        updatedClient.setCidade(client.getCidade());
        clientRepo.save(updatedClient);
        return "updated...";
    }

    @DeleteMapping(value = "/delete/{cpf}")
    public String deleteClient (@PathVariable int cpf) {
        Client deletedClient = clientRepo.findById(cpf).get();
        clientRepo.delete(deletedClient);
        return "deleted...";
    }
}
