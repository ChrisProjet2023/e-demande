package net.app.gespersonnelservice.service;

import lombok.AllArgsConstructor;
import net.app.gespersonnelservice.entities.Direction;
import net.app.gespersonnelservice.repository.DirectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DirectionService {

    private DirectionRepository directionRepository;

    public Direction createDirection(Direction direction){

        if(isExisteCodeDirection(direction.getCode())){
            throw new RuntimeException("Code de direction existant");
        }else {
            return directionRepository.save(direction);
        }

    }
 public Direction updateDirection(Long id,Direction updatedirection){
     Optional<Direction> directionOptional = directionRepository.findById(id);
     if(directionOptional.isPresent()){
         Direction direction = directionOptional.get();
         direction.setCode(updatedirection.getCode());
         direction.setDesignation(updatedirection.getDesignation());
         return directionRepository.save(direction);
     }
    return null;

 }

    public List<Direction> getAllDirection(){

        List<Direction> directions = directionRepository.findAll();
        if(!directions.isEmpty()){
           return directions.stream().collect(Collectors.toList());
       }
        return Collections.emptyList();

        //return  directionRepository.findAll();
    }

    public boolean isExisteCodeDirection(String code){
        return directionRepository.existsByCode(code);
    }
}
