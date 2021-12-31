package com.tqi_evolution_backend_2021.analisecred.controller;

import com.tqi_evolution_backend_2021.analisecred.model.ClienteModel;
import com.tqi_evolution_backend_2021.analisecred.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class ClienteController {

    @Autowired
    private ClienteRepository repository;
    private Integer id;

    @GetMapping (path = "api/cliente/{id}") /*para acessar ao banco de dados*/
    public ResponseEntity consultar (@PathVariable("id") Integer id){    /*metodo de consulta*/
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping(path = "api/cliente/salvar")
    public ClienteModel salvar(@RequestBody ClienteModel cliente){
        return repository.save(cliente);
    }
}
