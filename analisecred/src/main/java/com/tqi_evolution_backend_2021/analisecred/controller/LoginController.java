package com.tqi_evolution_backend_2021.analisecred.controller;
import com.tqi_evolution_backend_2021.analisecred.dto.LoginClientDTO;
import com.tqi_evolution_backend_2021.analisecred.dto.MensagemResponseDTO;
import com.tqi_evolution_backend_2021.analisecred.exception.ClientException;
import com.tqi_evolution_backend_2021.analisecred.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")

public class LoginController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public MensagemResponseDTO login(@RequestBody LoginClientDTO loginClientDTO) throws ClientException {

        return clientService.loginn(loginClientDTO);

    }

}