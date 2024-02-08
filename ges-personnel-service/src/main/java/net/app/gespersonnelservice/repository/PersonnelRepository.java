package net.app.gespersonnelservice.repository;

import net.app.gespersonnelservice.entities.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonnelRepository extends JpaRepository<Personnel, Long> {

     boolean existsByMatricule(String matricule);

     @Override
     List<Personnel> findAll();

    @Override
    Optional<Personnel> findById(Long aLong);
}
