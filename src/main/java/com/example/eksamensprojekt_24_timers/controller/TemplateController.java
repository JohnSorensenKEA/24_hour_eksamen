package com.example.eksamensprojekt_24_timers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/sogne")
    public String parishes(){
        return "parishes";
    }

    @GetMapping("/kommuner")
    public String communes(){
        return "communes";
    }
}
