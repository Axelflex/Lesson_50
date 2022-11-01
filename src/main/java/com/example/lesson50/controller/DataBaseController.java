package com.example.lesson50.controller;

import com.example.lesson50.service.DataBaseConnectivityService;
import com.example.lesson50.service.DataBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class DataBaseController {
    private final DataBaseConnectivityService dbcService;
    private final DataBaseService dbService;

    @GetMapping("/connect")
    public ResponseEntity<String> getConnection() {
        return new ResponseEntity<>(dbcService.openConnection(), HttpStatus.OK);
    }
    @GetMapping("/create")
    public ResponseEntity<String> createTable(){
        return new ResponseEntity<>(dbService.shouldCreateTable(), HttpStatus.OK);
    }
    @GetMapping("/conn")
    public ResponseEntity<String> connection(){
        return new ResponseEntity<>(dbService.getDataSourceConnection(), HttpStatus.OK);
    }
}
