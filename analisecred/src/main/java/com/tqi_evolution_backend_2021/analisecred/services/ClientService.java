package com.tqi_evolution_backend_2021.analisecred.services;

import com.tqi_evolution_backend_2021.analisecred.dto.LoginClientDTO;
import com.tqi_evolution_backend_2021.analisecred.dto.MensagemResponseDTO;
import com.tqi_evolution_backend_2021.analisecred.entity.Client;
import com.tqi_evolution_backend_2021.analisecred.exception.ClientException;
import com.tqi_evolution_backend_2021.analisecred.exception.ClientNotFoundException;
import com.tqi_evolution_backend_2021.analisecred.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    public Client UserLogin(@RequestBody Client clientLogin) throws ClientNotFoundException {
        Optional<Client> clienteOptional = clientRepository.GetLogin(clientLogin.getEmail(), clientLogin.getSenha());

        return clienteOptional.orElseThrow(() -> new ClientNotFoundException("Cliente não foi encontrado!"));
    }
    //Metodo Salvar Cliente
   public Client salvar(Client client) {
        return clientRepository.save(client);
    }
    //Metodo Listar Todos Clientes
    public List<Client> listaCliente() { //Metodo Listar Todos Clientes
        return clientRepository.findAll();
    }
    //Metodo Buscar Por Id
    public Optional<Client> buscarPorId(Long id) {
    return clientRepository.findById(id);
    }
    //Metodo Delete Por Id
    public void removerPorId(long id){
        clientRepository.deleteById(id);
    }
    //Metodo verificar login
    public MensagemResponseDTO loginn(LoginClientDTO loginClientDTO) throws ClientException {

        Optional<Client> optionalClient = clientRepository.findByEmail(loginClientDTO.getEmail());
        Client client = optionalClient.get();
        String msg = " ";

        if((client.getEmail().equals(loginClientDTO.getEmail()) &&
                (client.getSenha().equals(loginClientDTO.getSenha())))) {

            msg = "Bem Vindo ao Sistema!";

        } else msg = "Senha Inválida!";

        return MensagemResponseDTO
                .builder()
                .mensagem(msg)
                .build();
    }

}
