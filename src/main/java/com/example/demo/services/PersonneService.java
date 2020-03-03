package com.example.demo.services;

import com.example.demo.model.Personne;
import com.example.demo.repositories.PersonneRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log
public class PersonneService {

    private PersonneRepository personneRepository;

    @Autowired
    public void setPersonneRepository(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    public boolean savePersonne(Personne personne) {
        try {
            personneRepository.save(personne);
            return true;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;
        }
    }

    public List<Personne> findAll() {
        return personneRepository.findAll();
    }
}
