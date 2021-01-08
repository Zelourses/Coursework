package ru.coursework.coursework.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.coursework.coursework.Entity.Soldier;
import ru.coursework.coursework.repository.SoldierRepository;

@RestController
@RequestMapping("/api/war")
public class WarController {

    private final SoldierRepository soldierRepository;

    public WarController(SoldierRepository soldierRepository) {
        this.soldierRepository = soldierRepository;
    }

    @PutMapping("/newSoldier")
    @ResponseStatus(HttpStatus.CREATED)
    public void newSoldier(){
        soldierRepository.save(Soldier.newSimpleSoldier());
    }

    @GetMapping("/weaponize")
    public ResponseEntity weaponize(){
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/addSquad")
    public ResponseEntity addSquad(){
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/deleteSquad")
    public ResponseEntity deleteSquad(){
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }
}
