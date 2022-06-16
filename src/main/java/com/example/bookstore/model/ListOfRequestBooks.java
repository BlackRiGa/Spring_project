package com.example.bookstore.model;

import lombok.Data;

import java.util.UUID;

@Data
public class ListOfRequestBooks {
    private UUID requestUid;
    private UUID bookUid;
    private Integer count_book_request;
}
