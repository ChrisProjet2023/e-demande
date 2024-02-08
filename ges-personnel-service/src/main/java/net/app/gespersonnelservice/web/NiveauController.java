package net.app.gespersonnelservice.web;

import lombok.AllArgsConstructor;
import net.app.gespersonnelservice.entities.Niveau;
import net.app.gespersonnelservice.service.NiveauService;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/auth/niveau")
public class NiveauController {

    private NiveauService niveauService;

    @PostMapping("/create")
    public ResponseEntity<?> creationNiveau(@RequestBody Niveau niveau){
        Niveau createNiveau = niveauService.createNiveau(niveau);
        return  ResponseEntity.status(HttpStatus.CREATED).body(createNiveau);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Niveau>> ListeNiveau(){

        List<Niveau> niveauList = niveauService.getAllNiveau();
        if(niveauList != null){
            return ResponseEntity.ok(niveauList);
        }else {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        //return niveauService.getAllNiveau();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatedNiveau(@PathVariable Long id, @RequestBody Niveau niveau){

        try{
            Niveau updateNiveau = niveauService.updateNiveau(id,niveau);
            return  ResponseEntity.status(HttpStatus.CREATED).body(updateNiveau);
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseEntity.notFound().build();
        }
    }

}
