package com.example.bookstore.service;

import com.example.bookstore.dao.ClientEntity;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.Client;

import java.util.List;

public interface ClientService {
    Client getClientById(Long id);
    List<Client> getAllClients();
    List<Client> findByUsername(String username);
    void addClient(Client client);
    void editClient(Client client);
    void deleteClient(long id);
}
