package com.example.lesson50.controller;

import com.example.lesson50.dao.EventDAO;
import com.example.lesson50.dto.EventDTO;
import com.example.lesson50.model.Event;
import com.example.lesson50.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;
    private final EventDAO eventDAO;

    @GetMapping("/getAllEvents")
    public ResponseEntity<List<EventDTO>> getAllEvents(){
        return new ResponseEntity<>(eventService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/getAllBySubscribe")
    public ResponseEntity<List<EventDTO>> getAllBySubscribe(@RequestParam String email){
        return new ResponseEntity<>(eventService.getAllBySubscribe(email), HttpStatus.OK);
    }
    @PostMapping("/createEvent")
    public ResponseEntity<Long> createEvent(@RequestParam Event event){
        return new ResponseEntity<>(eventDAO.createEvent(event), HttpStatus.OK);
    }
    @PostMapping("/deleteEvent")
    public void deleteEvent(@RequestParam Long id){
        eventDAO.deleteEvent(id);
    }
}
