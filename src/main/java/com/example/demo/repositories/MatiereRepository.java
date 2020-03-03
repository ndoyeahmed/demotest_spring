package com.example.demo.repositories;

import com.example.demo.model.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere, Long> {
    @Query("select m from Matiere m where m.id not in (select c.matiere.id from Cours c where c.matiere is not null )")
    Optional<List<Matiere>> findAllByMatiereNotInCours();
}
