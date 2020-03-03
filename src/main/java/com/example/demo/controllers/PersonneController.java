package com.example.demo.controllers;

import com.example.demo.model.Personne;
import com.example.demo.repositories.PersonneRepository;
import com.example.demo.services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PersonneController {

    private PersonneService personneService;

    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("personnes")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(personneService.findAll());
    }

    @PostMapping("personnes")
    public ResponseEntity<?> addPersonne(@RequestBody Personne personne) {
        personneService.savePersonne(personne);
        return ResponseEntity.ok(true);
    }
}
