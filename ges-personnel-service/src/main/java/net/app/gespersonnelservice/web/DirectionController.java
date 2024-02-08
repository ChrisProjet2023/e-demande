package net.app.gespersonnelservice.web;

import lombok.AllArgsConstructor;
import net.app.gespersonnelservice.entities.Direction;
import net.app.gespersonnelservice.service.DirectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("api/auth/direction")
public class DirectionController {


   private DirectionService directionService;

   @GetMapping("/all")
   public ResponseEntity<List<Direction>> ListeDirection(){
       List<Direction> directionList = directionService.getAllDirection();
       if(directionList !=  null){
           return ResponseEntity.ok(directionList);
       }else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }

   }

   @PostMapping("/create")
   public ResponseEntity<?>  creationDirection(@RequestBody Direction direction){

       Direction creatDirection = directionService.createDirection(direction);
       return ResponseEntity.status(HttpStatus.CREATED).body(creatDirection);

    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateDirection(@PathVariable Long id, @RequestBody Direction direction){
       try {
            Direction updatedDirection = directionService.updateDirection(id,direction);
            return  ResponseEntity.status(HttpStatus.CREATED).body(updatedDirection);
       }catch (Exception e){
           e.printStackTrace();
           return  ResponseEntity.notFound().build();
       }
    }
}
