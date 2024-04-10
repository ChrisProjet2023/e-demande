package net.app.gesformationservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter @Getter @ToString
public class Personnel {
    private  Long id;
    private String matricule;
    private String nom;
    private  String prenom;
    private LocalDate dateNaissance;
    private LocalDate dateEmbauche;
    private  String sexe;
    private  String lieuNaissance;
    private  String email;
    private Long categorieId;
}
