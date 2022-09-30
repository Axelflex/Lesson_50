package com.example.lesson50.service;

import com.example.lesson50.dao.EventDAO;
import com.example.lesson50.dto.EventDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventDAO eventDAO;

    public List<EventDTO> getAll(){
        return eventDAO.getAllEvents().stream()
                .map(event -> EventDTO.builder()
                        .id(event.getId())
                        .dateTime(event.getDateTime())
                        .name(event.getName())
                        .description(event.getDescription())
                        .build())
                .collect(Collectors.toList());
    }

    public List<EventDTO> getAllBySubscribe(String email){
        return eventDAO.findBySubscriberEmail(email).stream()
                .map(event -> EventDTO.builder()
                        .id(event.getId())
                        .dateTime(event.getDateTime())
                        .name(event.getName())
                        .description(event.getDescription())
                        .build())
                .collect(Collectors.toList());
    }

}
