package net.app.gespersonnelservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
