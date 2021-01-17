package ru.coursework.coursework.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.coursework.coursework.DTO.request.newSoldierRequest;
import ru.coursework.coursework.Repositories.SoldierRepository;
import ru.coursework.coursework.Services.SoldiersService;

@RestController
@RequestMapping("/api/war")
public class WarController {

    final
    SoldiersService soldiersService;

    public WarController(SoldiersService soldiersService) {
        this.soldiersService = soldiersService;
    }

    @PutMapping("/newSoldier")
    public ResponseEntity newSoldier(@RequestBody newSoldierRequest newSoldier){
        soldiersService.newSoldier(newSoldier);
        return ResponseEntity.ok("OK");
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
