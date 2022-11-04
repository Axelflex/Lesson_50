package com.example.lesson50.controller;

import com.example.lesson50.dao.UserDAO;
import com.example.lesson50.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.StringConcatException;
import java.util.List;
import java.util.Optional;

@RestController("/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {

    private final UserDAO userDAO;
    private final JdbcTemplate jdbcTemplate;

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
    @GetMapping("/userByEmail")
    public ResponseEntity<Optional<User>> userByEmail(@RequestParam String email){
        return new ResponseEntity<>(userDAO.getUserByEmail(email), HttpStatus.OK);
    }
    @GetMapping("/isUserExist")
    public ResponseEntity<Boolean> isUserExist(@RequestParam String email){
        return new ResponseEntity<>(userDAO.isUserExist(email), HttpStatus.OK);
    }
    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User body){
        String sql = "INSERT INTO users(username, authority) " +
                "VALUES(?, USER);" ;
        jdbcTemplate.update(sql, body.getEmail());
        return new ResponseEntity<>(userDAO.addUser(body.getNickname(), body.getName(), body.getEmail(), body.getPassword()), HttpStatus.OK);
    }
    @PostMapping("/deleteAll")
    public void deleteAll(){
        userDAO.deleteAll();
    }
}
