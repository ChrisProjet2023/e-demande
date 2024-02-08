package net.app.gespersonnelservice.service;

import lombok.AllArgsConstructor;
import net.app.gespersonnelservice.entities.Personnel;
import net.app.gespersonnelservice.repository.PersonnelRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonnelService {

    private PersonnelRepository personnelRepository;
    private CategoriePersonnelService categoriePersonnelService;

    public  boolean isExistePersonnel(String matricule){
        return personnelRepository.existsByMatricule(matricule);
    }

    public Personnel createPersonnel(Personnel personnel) {
        System.out.println(categoriePersonnelService.isExisteIdCategorieP(personnel.getCategorieId()));
        if(categoriePersonnelService.isExisteIdCategorieP(personnel.getCategorieId())){
            if (isExistePersonnel(personnel.getMatricule())) {
                throw new RuntimeException("Un personnel existe déjà avec ce matricule");
            }
            return personnelRepository.save(personnel);
        }else{
//            if (!categoriePersonnelService.isExisteCodeCategorieP(personnel.getCategorieId().toString())){
//                throw  new RuntimeException("Categorie personnel inexistante");
//            }
                  throw  new RuntimeException("Categorie personnel inexistante");
            //return null


        }
        //return null;
       // return personnelRepository.save(personnel);
    }

    public  Personnel updatePersonnel(Long id,Personnel updatePersonnel) {
        Optional<Personnel> personnelOptional = personnelRepository.findById(id);
        if (personnelOptional.isPresent()) {
            Personnel personnel1 = personnelOptional.get();
            personnel1.setNom(updatePersonnel.getNom());
            personnel1.setPrenom(updatePersonnel.getPrenom());
            personnel1.setSexe(updatePersonnel.getSexe());
            personnel1.setEmail(updatePersonnel.getEmail());
            personnel1.setMatricule(updatePersonnel.getMatricule());
            personnel1.setLieuNaissance(updatePersonnel.getLieuNaissance());
            personnel1.setDateNaissance(updatePersonnel.getDateNaissance());
            personnel1.setDateEmbauche(updatePersonnel.getDateEmbauche());
            personnel1.setCategorieId(updatePersonnel.getCategorieId());
            personnelRepository.save(personnel1);
        }
        return null;
    }
    public List<Personnel> getAllPersonnel(){
        List<Personnel> personnels = personnelRepository.findAll();
        if(!personnels.isEmpty()){
            return  personnels.stream().collect(Collectors.toList());
        }
        return Collections.emptyList();
    }


}
