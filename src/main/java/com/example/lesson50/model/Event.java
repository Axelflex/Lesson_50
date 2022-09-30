package com.example.lesson50.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Event {
    private Long id;
    private LocalDateTime dateTime;
    private String name;
    private String description;
}
