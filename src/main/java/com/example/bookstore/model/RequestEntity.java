package com.example.bookstore.model;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestEntity {
    private UUID uid;
    private UUID publisherUid;
    private UUID bookUid;
}
