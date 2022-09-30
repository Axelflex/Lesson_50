package com.example.lesson50.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SubscribeEvent {
    private Long id;
    private Event event;
    private String email;
    private LocalDateTime registerDateTime;
}
