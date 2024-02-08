package net.app.gespersonnelservice.repository;

import net.app.gespersonnelservice.entities.CategoriePersonnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
public interface CategoriePersonnelRepository extends JpaRepository<CategoriePersonnel, Long> {

    boolean existsByCode(String code);
    boolean existsById(Long id);

    public List<CategoriePersonnel> findAll();

    @Override
    Optional<CategoriePersonnel> findById(Long id);
}
