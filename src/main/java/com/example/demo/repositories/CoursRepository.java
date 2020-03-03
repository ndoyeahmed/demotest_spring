package com.example.demo.repositories;

import com.example.demo.model.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {
    Optional<Cours> findCoursByMatiere_LibelleAndProfesseur_Code(String matiere, String code);
}
