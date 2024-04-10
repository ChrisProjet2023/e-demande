package net.app.gesformationservice.repository;

import net.app.gesformationservice.entities.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
public interface PaysRepository extends JpaRepository<Pays, Long> {

    boolean existsByCodeIso(String codeIso);
    boolean existsById(Long id);

    public List<Pays> findAll();

    @Override
    Optional<Pays> findById(Long id);
}
