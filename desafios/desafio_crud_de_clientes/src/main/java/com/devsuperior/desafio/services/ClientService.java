package com.devsuperior.desafio.services;

import com.devsuperior.desafio.dto.ClientDTO;
import com.devsuperior.desafio.entities.Client;
import com.devsuperior.desafio.repositories.ClientRepository;
import com.devsuperior.desafio.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        Client client = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Id " + id + " não encontrado!"));
        //Copiar os dados para o DTO
        ClientDTO dto = new ClientDTO(client);
       return new ClientDTO(client);
   }
    private void copyDtoToEntity(ClientDTO dto, Client client) {
        client.setName((dto.getName()));
        client.setCpf((dto.getCpf()));
        client.setIncome((dto.getIncome()));
        client.setBirthDate((dto.getBirthDate()));
        client.setChildren((dto.getChildren()));
    }
}
