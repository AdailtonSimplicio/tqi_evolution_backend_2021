package com.tqi_evolution_backend_2021.analisecred.controller;

import com.tqi_evolution_backend_2021.analisecred.dto.MessagerResponseDTO;
import com.tqi_evolution_backend_2021.analisecred.entity.Person;
import com.tqi_evolution_backend_2021.analisecred.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clientes")

public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @PostMapping
    public MessagerResponseDTO createPerson(@RequestBody Person person){
        Person savedPerson = personRepository.save(person);
        return MessagerResponseDTO
                .builder()
                .messeger("create person widt ID" + savedPerson.getId())
                .build();
    }

}
