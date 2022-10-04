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
import java.util.Optional;

@RestController("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserDAO userDAO;

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userDAO.getAllUsers(), HttpStatus.OK);
    }
    @PostMapping("/userByName")
    public ResponseEntity<List<User>> userByName(@RequestParam String name){
        return new ResponseEntity<>(userDAO.getUserByName(name), HttpStatus.OK);
    }
    @PostMapping("/userByNickname")
    public ResponseEntity<List<User>> userByNickname(@RequestParam String nickname){
        return new ResponseEntity<>(userDAO.getUserByNickname(nickname), HttpStatus.OK);
    }
    @PostMapping("/userByEmail")
    public ResponseEntity<Optional<User>> userByEmail(@RequestParam String email){
        return new ResponseEntity<>(userDAO.getUserByEmail(email), HttpStatus.OK);
    }
    @PostMapping("/isUserExist")
    public ResponseEntity<Boolean> isUserExist(@RequestParam String email){
        return new ResponseEntity<>(userDAO.isUserExist(email), HttpStatus.OK);
    }
    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestParam String nickname,
                        @RequestParam String name,
                        @RequestParam String email,
                        @RequestParam String password){
        return new ResponseEntity<>(userDAO.addUser(nickname, name, email, password), HttpStatus.OK);
    }
    @PostMapping("/deleteAll")
    public void deleteAll(){
        userDAO.deleteAll();
    }
}
