package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@Entity
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String intitule;
    private String date;
    private String jour;
    private String heureDebut;
    private String heureFin;
    private String anneeAcademique;
    private Integer coef;

    @ManyToOne
    @JoinColumn(name = "matiere", referencedColumnName = "id")
    private Matiere matiere;

    @ManyToOne
    @JoinColumn(name = "salle", referencedColumnName = "id")
    private Salle salle;

    @ManyToOne
    @JoinColumn(name = "professeur", referencedColumnName = "id")
    private Professeur professeur;
    @ManyToOne
    @JoinColumn(name = "classe", referencedColumnName = "id")
    private Classe classe;
}
