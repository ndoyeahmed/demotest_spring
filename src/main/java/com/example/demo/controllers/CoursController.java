package com.example.demo.controllers;

import com.example.demo.repositories.CoursRepository;
import com.example.demo.repositories.MatiereRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Objects;

@Controller
@Log
@RequestMapping("/")
public class CoursController {

    private CoursRepository coursRepository;
    private MatiereRepository matiereRepository;

    @Autowired
    public void setCoursRepository(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }

    @Autowired
    public void setMatiereRepository(MatiereRepository matiereRepository) {
        this.matiereRepository = matiereRepository;
    }

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("matieres")
    public ResponseEntity<?> listMatiere() {
        return ResponseEntity.ok(matiereRepository
                .findAllByMatiereNotInCours().orElse(new ArrayList<>()));
    }

    @GetMapping("cours/{code}/{matiere}")
    public ResponseEntity<?> coursByCodeProfAndMatiere(@PathVariable String code, @PathVariable String matiere) {
        return ResponseEntity.ok(Objects.requireNonNull(coursRepository.findCoursByMatiere_LibelleAndProfesseur_Code(code, matiere)
                .orElse(null)));
    }
}
