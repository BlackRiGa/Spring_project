package com.example.bookstore.model;

import lombok.Data;

import java.util.UUID;

@Data
public class ListOfOrderBooks {
    private UUID orderUid;
    private UUID bookUid;
    private Integer count_book_order;
}
