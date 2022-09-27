package com.example.lesson50.controller;

import com.example.lesson50.dao.UserDAO;
import com.example.lesson50.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserDAO userDAO;

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userDAO.getAllUsers(), HttpStatus.OK);
    }
    @PostMapping("/userByName")
    public ResponseEntity<List<User>> userByName(){
        return new ResponseEntity<>(userDAO.getUserByName(), HttpStatus.OK);
    }
    @PostMapping("/userByNickname")
    public ResponseEntity<List<User>> userByNickname(){
        return new ResponseEntity<>(userDAO.getUserByNickname(), HttpStatus.OK);
    }
    @PostMapping("/userByEmail")
    public ResponseEntity<List<User>> userByEmail(){
        return new ResponseEntity<>(userDAO.getUserByEmail(), HttpStatus.OK);
    }
    @PostMapping("/isUserExist")
    public ResponseEntity<Boolean> isUserExist(){
        return new ResponseEntity<>(userDAO.isUserExist(), HttpStatus.OK);
    }
    @PostMapping("/addUser")
    public void addUser(){
        userDAO.addUser();
    }
    @PostMapping("/deleteAll")
    public void deleteAll(){
        userDAO.deleteAll();
    }
}
