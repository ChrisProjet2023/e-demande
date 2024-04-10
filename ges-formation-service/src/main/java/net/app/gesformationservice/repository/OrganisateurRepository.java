package net.app.gesformationservice.repository;


import net.app.gesformationservice.entities.Organisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
public interface OrganisateurRepository extends JpaRepository<Organisateur, Long> {

    boolean existsByEmailOrg(String email);
    boolean existsById(Long id);
    boolean existsByTel(String tel);

    public List<Organisateur> findAll();

    @Override
    Optional<Organisateur> findById(Long id);
}
