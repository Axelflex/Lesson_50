package com.example.lesson50.controller;

import com.example.lesson50.dto.SubscribeEventDTO;
import com.example.lesson50.service.SubscribeEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/subscriptions")
@RequiredArgsConstructor
public class SubscriptionEventController {
    private final SubscribeEventService service;

    @PostMapping("/createEventSub")
    public ResponseEntity<?> createEventSub(@RequestParam String email, Long id){
        return new ResponseEntity<>(service.createSubscription(email, id), HttpStatus.OK);
    }
    @PostMapping("/deleteEventSub")
    public void deleteEventSub(@RequestParam String email, @RequestParam Long id){
        service.deleteSubscription(email, id);
    }
}
