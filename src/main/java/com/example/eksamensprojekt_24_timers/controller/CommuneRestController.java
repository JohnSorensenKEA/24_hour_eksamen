package com.example.eksamensprojekt_24_timers.controller;

import com.example.eksamensprojekt_24_timers.model.Commune;
import com.example.eksamensprojekt_24_timers.service.CommuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommuneRestController {

    @Autowired
    CommuneService communeService;

    @GetMapping("/allCommunes")
    public List<Commune> allCommunes(){
        return communeService.getAllCommunes();
    }
}
