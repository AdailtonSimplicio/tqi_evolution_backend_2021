package com.tqi_evolution_backend_2021.analisecred.controller;

import com.tqi_evolution_backend_2021.analisecred.model.ClienteModel;
import com.tqi_evolution_backend_2021.analisecred.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.util.List;

@RestController
@AllArgsConstructor

public class ClienteController {

    ClienteRepository repository;

    @GetMapping ("/Clientes")
    public List<ClienteModel> getAllClientes(){
        return (List<ClienteModel>) repository.findAll();
    }
}
