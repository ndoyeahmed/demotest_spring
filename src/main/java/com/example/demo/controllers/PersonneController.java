package com.example.demo.controllers;

import com.example.demo.model.Personne;
import com.example.demo.repositories.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personnes")
public class PersonneController {

    @Autowired
    private PersonneRepository personneRepository;

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(personneRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> addPersonne(@RequestBody Personne personne) {
        personneRepository.save(personne);
        return ResponseEntity.ok(true);
    }
}
