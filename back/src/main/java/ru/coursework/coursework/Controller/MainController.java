package ru.coursework.coursework.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.coursework.coursework.DTO.response.DataResponse;
import ru.coursework.coursework.Services.DataService;
import ru.coursework.coursework.Services.DateService;


@RestController
@RequestMapping("/api")
public class MainController {

    final DataService dataService;
    public MainController(DataService dataService) {
        this.dataService = dataService;
    }

    @RequestMapping(value = "/nextDay", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public DataResponse nextDay(){
        return dataService.nextDay();
    }

    @RequestMapping(value = "/getData", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public DataResponse getData(){
        return dataService.getData();
    }


}
