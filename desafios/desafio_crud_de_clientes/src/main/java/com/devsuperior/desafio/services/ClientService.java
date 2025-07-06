package com.devsuperior.desafio.services;

import com.devsuperior.desafio.dto.ClientDTO;
import com.devsuperior.desafio.entities.Client;
import com.devsuperior.desafio.repositories.ClientRepository;
import com.devsuperior.desafio.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> result = repository.findAll(pageable);
        return result.map(x -> new ClientDTO(x));
    }
    public ClientDTO insert(ClientDTO dto){
        Client entity = new Client();
        copyDtoToEntity(dto, entity);

        //Salvar no DB
        entity = repository.save(entity);
        return new ClientDTO(entity);
    }
    @Transactional
    public ClientDTO update(Long id, ClientDTO dto){
        try {
            //Instanciar com a referência
            Client entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            //Salvar no DB
            entity = repository.save(entity);
            return new ClientDTO(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Id " + id + " não encontrado. Verifique o id digitado!");
        }
    }

    @Transactional
    public void delete(Long id){
        if(!repository.existsById(id))
        {
            throw new ResourceNotFoundException("Id " + id + " não encontrado! Verifique o id e tente novamente");
        }
        else {
            repository.deleteById(id);
        }
    }

    private void copyDtoToEntity(ClientDTO dto, Client client) {
        client.setName((dto.getName()));
        client.setCpf((dto.getCpf()));
        client.setIncome((dto.getIncome()));
        client.setBirthDate((dto.getBirthDate()));
        client.setChildren((dto.getChildren()));
    }
}
