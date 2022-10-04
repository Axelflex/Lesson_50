package com.example.lesson50.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Event {
    private Long id;
    private LocalDateTime dateTime;
    private String name;
    private String description;

}
