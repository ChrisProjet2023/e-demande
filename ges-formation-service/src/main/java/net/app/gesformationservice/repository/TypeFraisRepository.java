package net.app.gesformationservice.repository;

import net.app.gesformationservice.entities.TypeFrais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
public interface TypeFraisRepository extends JpaRepository<TypeFrais, Long> {

    boolean existsById(Long id);
    public List<TypeFrais> findAll();

    @Override
    Optional<TypeFrais> findById(Long id);
}
