package com.example.demo.repositories;

import com.example.demo.model.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere, Long> {
    @Query("select m from Matiere m where m not in (select c.matiere from Cours c)")
    Optional<List<Matiere>> findAllByMatiereNotInCours();
}
