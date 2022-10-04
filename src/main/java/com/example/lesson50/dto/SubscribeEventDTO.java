package com.example.lesson50.dto;

import com.example.lesson50.model.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscribeEventDTO {
    private Long id;
    private EventDTO event;
    private String email;
    private LocalDateTime registerDateTime;

}
