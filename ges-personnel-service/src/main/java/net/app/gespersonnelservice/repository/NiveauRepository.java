package net.app.gespersonnelservice.repository;

import net.app.gespersonnelservice.entities.Direction;
import net.app.gespersonnelservice.entities.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NiveauRepository extends JpaRepository<Niveau, Long> {

    boolean existsByCode(String code);

    @Override
    List<Niveau> findAll();

    @Override
    Optional<Niveau> findById(Long id);
}
