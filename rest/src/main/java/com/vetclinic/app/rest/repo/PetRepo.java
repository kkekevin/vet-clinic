package com.vetclinic.app.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vetclinic.app.rest.models.Pet;

import jakarta.transaction.Transactional;

@Repository
public interface PetRepo extends JpaRepository<Pet, Integer> {

    @Transactional
    @Modifying  
    @Query(value = "DELETE FROM Pet * WHERE cpf=:cpf AND nome=:nome", nativeQuery = true)
    public void deletePetByName(@Param("cpf") String cpf, @Param("nome") String nome);
}
