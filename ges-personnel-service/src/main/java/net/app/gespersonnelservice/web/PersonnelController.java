package net.app.gespersonnelservice.web;

import lombok.AllArgsConstructor;
import net.app.gespersonnelservice.entities.Niveau;
import net.app.gespersonnelservice.entities.Personnel;
import net.app.gespersonnelservice.service.PersonnelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/auth/personnel")
public class PersonnelController {

    private PersonnelService personnelService;

    @PostMapping("/create")
    public ResponseEntity<?> creationPersonnel(@RequestBody Personnel personnel){
        Personnel createPersonnel = personnelService.createPersonnel(personnel);
        return  ResponseEntity.status(HttpStatus.CREATED).body(createPersonnel);
    }

    @GetMapping("all")
    public ResponseEntity<List<Personnel>> ListePersonnel(){
        List<Personnel> personnels = personnelService.getAllPersonnel();
        if(personnels != null){
            return ResponseEntity.ok(personnels);
        }else{
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("update/{id}")
  public ResponseEntity<?> updatedPersonnel(@PathVariable Long id, @RequestBody Personnel personnel){
        try {
            Personnel updatePersonnel = personnelService.updatePersonnel(id, personnel);
            return ResponseEntity.status(HttpStatus.CREATED).body(personnel);

        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();

        }
  }




}
