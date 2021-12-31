package com.tqi_evolution_backend_2021.analisecred.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class StatusController {
    @GetMapping (path = "api/status")
    public String check(){
        return "online";
    }
}
