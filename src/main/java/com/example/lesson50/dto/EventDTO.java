package com.example.lesson50.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class EventDTO {
    private Long id;
    private LocalDateTime dateTime;
    private String name;
    private String description;
}
