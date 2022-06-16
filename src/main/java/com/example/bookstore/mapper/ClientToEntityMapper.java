package com.example.bookstore.mapper;

import com.example.bookstore.dao.ClientEntity;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookRequest;
import com.example.bookstore.model.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientToEntityMapper {
    ClientEntity clientToClientEntity(Client client);
    Client clientEntityToClient(ClientEntity clientEntity);
}
