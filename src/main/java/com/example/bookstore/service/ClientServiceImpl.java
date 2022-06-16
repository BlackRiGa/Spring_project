package com.example.bookstore.service;

import com.example.bookstore.dao.ClientEntity;
import com.example.bookstore.exception.NotFoundException;
import com.example.bookstore.mapper.ClientToEntityMapper;
import com.example.bookstore.model.Client;
import com.example.bookstore.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service()
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientToEntityMapper mapper;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, ClientToEntityMapper mapper) {
        this.clientRepository = clientRepository;
        this.mapper = mapper;
    }

    @Override
    public Client getClientById(Long id) {
        ClientEntity clientEntity = clientRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Book not found: id = " + id));

        return mapper.clientEntityToClient(clientEntity);
    }

    @Override
    public List<Client> getAllClients() {
        Iterable<ClientEntity> iterable = clientRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(mapper::clientEntityToClient)
                .collect(Collectors.toList());
    }

    @Override
    public List<Client> findByUsername(String username) {
        Iterable<ClientEntity> iterable = clientRepository.findAllByUsernameContaining(username);
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(mapper::clientEntityToClient)
                .collect(Collectors.toList());
    }

    @Override
    public void addClient(Client client) {
        ClientEntity clientEntity = mapper.clientToClientEntity(client);
        clientRepository.save(clientEntity);
    }

    @Override
    public void editClient(Client client) {
        if (!clientRepository.existsById(client.getId()))
            throw new NotFoundException("Client not found: id = " + client.getId());
        ClientEntity clientEntity = mapper.clientToClientEntity(client);
        clientRepository.save(clientEntity);
    }

    @Override
    public void deleteClient(long id) {
        ClientEntity client = clientRepository.findById(id).orElseThrow();
        clientRepository.delete(client);
    }

}
