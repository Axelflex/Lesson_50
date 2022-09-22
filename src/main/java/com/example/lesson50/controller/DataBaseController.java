package com.example.lesson50.controller;

import com.example.lesson50.model.Customer;
import com.example.lesson50.service.DataBaseConnectivityService;
import com.example.lesson50.service.DataBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
@RequiredArgsConstructor
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
    @GetMapping("/select")
    public ResponseEntity<String> select(){
        return new ResponseEntity<>(dbService.shouldSelectData(), HttpStatus.OK);
    }
    @GetMapping("/insert")
    public ResponseEntity<String> insert(){
        dbService.shouldResultSet();
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/conn")
    public ResponseEntity<String> connection(){
        return new ResponseEntity<>(dbService.getDataSourceConnection(), HttpStatus.OK);
    }
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> customers(){
        return new ResponseEntity<>(dbService.getCustomers(), HttpStatus.OK);
    }







}
