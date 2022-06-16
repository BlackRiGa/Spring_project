package com.example.bookstore.model;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class Client {
    Long id;
    String username;
    String email;
}
