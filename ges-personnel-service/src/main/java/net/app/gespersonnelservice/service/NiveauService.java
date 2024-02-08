package net.app.gespersonnelservice.service;

import lombok.AllArgsConstructor;
import net.app.gespersonnelservice.entities.Niveau;
import net.app.gespersonnelservice.repository.NiveauRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NiveauService {

    private NiveauRepository niveauRepository;

    public  boolean isExisteNiveau(String code){
        return  niveauRepository.existsByCode(code);
    }

    public Niveau createNiveau(Niveau niveau){
        if(isExisteNiveau(niveau.getCode())){
            throw new RuntimeException("Niveau existant");
        }
        return niveauRepository.save(niveau);
    }

    public  Niveau updateNiveau(Long id, Niveau updatedNiveau){
        Optional<Niveau> niveauOptional = niveauRepository.findById(id);
        if(niveauOptional.isPresent()){
            Niveau niveau = niveauOptional.get();
            niveau.setCode(updatedNiveau.getCode());
           return  niveauRepository.save(niveau);
        }
        return null;
    }

    public List<Niveau> getAllNiveau(){
        List<Niveau> niveaux =  niveauRepository.findAll();
        if(!niveaux.isEmpty()){
            return  niveaux.stream().collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

}
