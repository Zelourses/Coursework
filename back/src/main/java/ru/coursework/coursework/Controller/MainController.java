package ru.coursework.coursework.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MainController {

    @RequestMapping(value = "/nextDay", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity nextDay(){
        return ResponseEntity.ok("Next day... data: {nothing, at least now}");
    }

    @RequestMapping(value = "/getData", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getData(){
        return ResponseEntity.ok("Here is your data: {nothing, at least now}");
    }


}
