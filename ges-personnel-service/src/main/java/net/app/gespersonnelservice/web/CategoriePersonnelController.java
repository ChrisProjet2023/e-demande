package net.app.gespersonnelservice.web;

import lombok.AllArgsConstructor;
import net.app.gespersonnelservice.entities.CategoriePersonnel;
import net.app.gespersonnelservice.entities.Direction;
import net.app.gespersonnelservice.service.CategoriePersonnelService;
import net.app.gespersonnelservice.service.NiveauService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/auth/categoriePersonnel")
@AllArgsConstructor
public class CategoriePersonnelController {
    private CategoriePersonnelService categoriePersonnelService;
    private NiveauService niveauService;

    @GetMapping("/all")
    public ResponseEntity<List<CategoriePersonnel>> ListeCategoriePersonnel(){
        List<CategoriePersonnel> categoriePersonnelList =  categoriePersonnelService.getAllCategoriePersonnel();
//       categoriePersonnelList.forEach(catego->{
//           catego.setNiveau(catego.getNiveauId());
//       });

        if(!categoriePersonnelList.isEmpty()){
            return  ResponseEntity.ok(categoriePersonnelList);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    public List<BankAccount> accountList(){
//
//        List<BankAccount> accountList  = accountRespository.findAll();
//        accountList.forEach(acc->{
//            acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()));
//
//        });
//        return accountList;
//    }

    @PostMapping("/create")
    public ResponseEntity<?>  creationCategoriePersonnel(@RequestBody CategoriePersonnel categoriePersonnel){

        CategoriePersonnel createcategoriePersonnel = categoriePersonnelService.createCategoriePersonnel(categoriePersonnel);
        return ResponseEntity.status(HttpStatus.CREATED).body(createcategoriePersonnel);

    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateCategoriePersonnel(@PathVariable Long id, @RequestBody CategoriePersonnel categoriePersonnel){
        try {
            CategoriePersonnel updateCategoriePersonnel  = categoriePersonnelService.updateCategoriePersonnel(id, categoriePersonnel);
            return  ResponseEntity.status(HttpStatus.CREATED).body(updateCategoriePersonnel);
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseEntity.notFound().build();
        }
    }




}
