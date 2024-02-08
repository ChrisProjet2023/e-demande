package net.app.gespersonnelservice.repository;

import net.app.gespersonnelservice.entities.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DirectionRepository extends JpaRepository<Direction, Long> {

    boolean existsByCode(String codeDirection);

    @Override
    List<Direction> findAll();

    @Override
    Optional<Direction> findById(Long id);

//    @Query("select  from direction where code=:codeDirection")
//    Optional<Direction> findDirectionByCode(@Param("codeDirection") String codeDirection);
}
