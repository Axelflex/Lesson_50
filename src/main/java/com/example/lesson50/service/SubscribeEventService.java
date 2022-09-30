package com.example.lesson50.service;

import com.example.lesson50.dao.EventDAO;
import com.example.lesson50.dao.SubscribeEventDAO;
import com.example.lesson50.dto.EventDTO;
import com.example.lesson50.dto.SubscribeEventDTO;
import com.example.lesson50.model.Event;
import com.example.lesson50.model.SubscribeEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SubscribeEventService {

    private final SubscribeEventDAO subscribeEventDAO;
    private final EventDAO eventDAO;

    public ResponseEntity<?> createSubscription(String email, Long eventId){
        Long id = subscribeEventDAO.createSub(email, eventId);
        SubscribeEvent subscribeEvent = subscribeEventDAO.findById(id).orElseThrow();
        Event event = eventDAO.findById(subscribeEvent.getEvent().getId()).orElseThrow();

        if(event.getDateTime().isBefore(LocalDateTime.now())){
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(SubscribeEventDTO.builder()
                .id(subscribeEvent.getId())
                .event(EventDTO.builder()
                        .id(event.getId())
                        .name(event.getName())
                        .description(event.getDescription())
                        .dateTime(event.getDateTime())
                        .build())
                .email(subscribeEvent.getEmail())
                .registerDateTime(subscribeEvent.getRegisterDateTime())
                .build(), HttpStatus.OK);
    }

    public void deleteSubscription(String email, Long id){
        SubscribeEvent subscribeEvent = subscribeEventDAO.findByEmailAndEventId(email, id).orElseThrow();
        subscribeEventDAO.deleteSub(subscribeEvent.getId());
    }

}
