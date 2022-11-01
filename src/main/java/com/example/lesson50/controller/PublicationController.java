package com.example.lesson50.controller;

import com.example.lesson50.dao.PublicationDAO;
import com.example.lesson50.model.Publication;
import com.example.lesson50.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/publications")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PublicationController {

    private final PublicationDAO publicationDAO;
    @GetMapping("/allPubs")
    public ResponseEntity<List<Publication>> getAllPubs(){
        return new ResponseEntity<>(publicationDAO.getAllPub(), HttpStatus.OK);
    }
    @GetMapping("/allPubsSubscribed")
    public ResponseEntity<List<Publication>> getAllSubscribedPubs(@RequestParam Integer user_id){
        return new ResponseEntity<>(publicationDAO.getAllPubsOfFollowers(user_id), HttpStatus.OK);
    }
    @PostMapping("/deletePub")
    public void deletePub(@RequestParam Integer user_id){
        publicationDAO.deletePub(user_id);
    }
    @PostMapping("/createPub")
    public void createPub(@RequestParam Integer user_id, @RequestParam String photo, @RequestParam String datetime){
        publicationDAO.createPub(user_id, photo, datetime);
    }
}
