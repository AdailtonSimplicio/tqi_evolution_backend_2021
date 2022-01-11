package com.tqi_evolution_backend_2021.analisecred.controller;
import com.tqi_evolution_backend_2021.analisecred.entity.Client;
import com.tqi_evolution_backend_2021.analisecred.exception.ClientNotFoundException;
import com.tqi_evolution_backend_2021.analisecred.services.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/cliente")

public class ClientController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private ModelMapper modelMapper;

    //Metodo para salvar cliente
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client salvar(@RequestBody Client client){
        return clientService.salvar(client);
    }
    //Metodo listar cliente
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Client> listaCliente(){
        return clientService.listaCliente();
    }
    //Metodo buscar por ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client buscarClientePorId(@PathVariable("id")Long id){
        return clientService.buscarPorId(id)
                .orElseThrow(() ->new  ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não localizado!"));
    }
    //Metodo deletar por id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable("id")Long id){
        clientService.buscarPorId(id)
                .map(client -> {
                    clientService.removerPorId(client.getId());
                    return Void.TYPE;
                }).orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não localizado!"));
    }
    //Metodo de atualização do cliente
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarCliente(@PathVariable("id") Long id,@RequestBody Client client){
        clientService.buscarPorId(id)
                .map(clientBase ->{
                    modelMapper.map(client,clientBase);
                    return Void.TYPE;
                }).orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não localizado!"));
    }

    //Metodo verificando seu email e a senha.

    @RequestMapping(value = "/cliente/login/",method = RequestMethod.GET)
    public Client UserLogin(@RequestBody Client clientLogin) throws ClientNotFoundException {

        return clientService.UserLogin(clientLogin);
    }
}

