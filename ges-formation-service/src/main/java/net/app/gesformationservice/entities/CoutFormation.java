package net.app.gesformationservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.app.gesformationservice.model.Personnel;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CoutFormation {

    private Long formationId;
    private Long typeFraisId;
    @Transient
    private Personnel personnel;
    private Long personnelId;
    private int cout;
    private int nbreJours;
}
