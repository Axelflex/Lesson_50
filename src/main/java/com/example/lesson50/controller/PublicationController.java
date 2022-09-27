package com.example.lesson50.controller;

import com.example.lesson50.dao.PublicationDAO;
import com.example.lesson50.model.Publication;
import com.example.lesson50.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/publications")
@RequiredArgsConstructor
public class PublicationController {

    private final PublicationDAO publicationDAO;
    @GetMapping("/allPubs")
    public ResponseEntity<List<Publication>> getAllPubs(){
        return new ResponseEntity<>(publicationDAO.getAllPub(), HttpStatus.OK);
    }
    @GetMapping("/allPubsSubscribed")
    public ResponseEntity<List<Publication>> getAllSubscribedPubs(){
        return new ResponseEntity<>(publicationDAO.getAllPubsOfFollowers(), HttpStatus.OK);
    }
    @PostMapping("/deletePub")
    public void deletePub(){
        publicationDAO.deletePub();
    }
    @PostMapping("/createPub")
    public void createPub(){
        publicationDAO.createPub();
    }
}
