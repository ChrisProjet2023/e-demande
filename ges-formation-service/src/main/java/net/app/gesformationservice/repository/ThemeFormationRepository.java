package net.app.gesformationservice.repository;

import net.app.gesformationservice.entities.ThemeFormation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
public interface ThemeFormationRepository extends JpaRepository<ThemeFormation, Long> {

    boolean existsById(Long id);
    boolean existsByCode(String code);
    public List<ThemeFormation> findAll();

    @Override
    Optional<ThemeFormation> findById(Long id);
}
