package com.tqi_evolution_backend_2021.analisecred.controller;

import com.tqi_evolution_backend_2021.analisecred.entity.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/clientes")

public class PersonController {

    @GetMapping
    public String getBook(){
        return "API Controller funcionando";
    }

}
