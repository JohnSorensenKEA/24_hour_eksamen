package com.example.eksamensprojekt_24_timers.controller;

import com.example.eksamensprojekt_24_timers.model.Parish;
import com.example.eksamensprojekt_24_timers.service.ParishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ParishRestController {

    @Autowired
    ParishService parishService;

    @GetMapping("/allParishes")
    public List<Parish> allCommunes(){
        return parishService.getAllParishes();
    }

    @DeleteMapping(value = "/deleteParish", consumes = "application/json")
    public ResponseEntity<Parish> deleteParish(@RequestBody Parish parish){
        parishService.deleteParish(parish);
        return new ResponseEntity<>(parish, HttpStatus.OK);
    }

    @PostMapping(value = "/newParish", consumes = "application/json")
    public ResponseEntity<Parish> createParish(@RequestBody Parish parish){
        Parish newParish = parishService.createParish(parish);
        return new ResponseEntity<>(newParish, HttpStatus.OK);
    }

    @PutMapping(value = "/updateParish", consumes = "application/json")
    public ResponseEntity<Parish> updateParish(@RequestBody Parish parish){
        Parish changedParish = parishService.updateParish(parish);
        return new ResponseEntity<>(changedParish, HttpStatus.OK);
    }

    @GetMapping("/communeParishes/{id}")
    public List<Parish> communeParishes(@PathVariable Integer id){
        return parishService.getParishesByCommune(id);
    }

    @PutMapping(value = "/removeShutDown", consumes = "application/json")
    public ResponseEntity<Parish> removeShutDown(@RequestBody Parish parish){
        return new ResponseEntity<>(parishService.removeShutDown(parish), HttpStatus.OK);
    }

    @PutMapping(value = "/newShutDown", consumes = "application/json")
    public ResponseEntity<Parish> newShutDown(@RequestBody Parish parish){
        return new ResponseEntity<>(parishService.newShutDown(parish), HttpStatus.OK);
    }
}
