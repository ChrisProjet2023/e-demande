package net.app.gespersonnelservice.service;

import lombok.AllArgsConstructor;
import net.app.gespersonnelservice.entities.CategoriePersonnel;
import net.app.gespersonnelservice.repository.CategoriePersonnelRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoriePersonnelService {

    private CategoriePersonnelRepository categoriePersonnelRepository;

    public  boolean isExisteCodeCategorieP(String code){
        return categoriePersonnelRepository.existsByCode(code);
    }

    public boolean isExisteIdCategorieP(Long id){
        return categoriePersonnelRepository.existsById(id);
    }


    public CategoriePersonnel createCategoriePersonnel(CategoriePersonnel categoriePersonnel){
        if(isExisteCodeCategorieP(categoriePersonnel.getCode())){
            throw  new RuntimeException("Catégorie du personnel existe déjà");
        }
        return categoriePersonnelRepository.save(categoriePersonnel);
    }

    public CategoriePersonnel updateCategoriePersonnel(Long id, CategoriePersonnel updateCategoriePersonnel){
        Optional<CategoriePersonnel> categoriePersonnelOptional = categoriePersonnelRepository.findById(id);
        if(categoriePersonnelOptional.isPresent()){
            CategoriePersonnel categoriePersonnel = categoriePersonnelOptional.get();
            categoriePersonnel.setCode(updateCategoriePersonnel.getCode());
            categoriePersonnel.setLibelle(updateCategoriePersonnel.getLibelle());
            categoriePersonnel.setNiveauId(updateCategoriePersonnel.getNiveauId());
            return categoriePersonnelRepository.save(categoriePersonnel);
        }
        return  null;
    }
    public List<CategoriePersonnel> getAllCategoriePersonnel(){

        List<CategoriePersonnel> categoriePersonnels = categoriePersonnelRepository.findAll();
        if(!categoriePersonnels.isEmpty()){
          return  categoriePersonnels.stream().collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
