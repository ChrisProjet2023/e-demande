package net.app.gesformationservice.repository;

import net.app.gesformationservice.entities.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
public interface FormationRepository extends JpaRepository<Formation, Long> {

    @Override
    boolean existsById(Long id);
    public List<Formation> findAll();

    @Override
    Optional<Formation> findById(Long id);

    @Query(value = "select * from formation fwhere dateDebut between :dateDeb and :dateFin", nativeQuery = true)
    public Formation findByDateDebut(@Param("dateDeb") Date dateDebut, @Param("dateFin") Date dateFin);

     List<Formation> findAllByDateDebutAndDateFin(Date dateDebut, Date dateFin);

}
