package com.example.bookstore.component;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DaySimulationComponent {
    public Date getCurrentDate() {
        return new Date();
    }
}
