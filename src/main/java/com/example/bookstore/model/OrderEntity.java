package com.example.bookstore.model;
import lombok.Data;

import java.util.UUID;

@Data
public class OrderEntity {
    private UUID uid;
    private UUID clientUid;
    private UUID bookUid;
}
