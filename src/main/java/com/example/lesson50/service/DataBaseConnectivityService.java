package com.example.lesson50.service;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Service
public class DataBaseConnectivityService {
    @Getter
    private Connection connection;

    public DataBaseConnectivityService(){
        try{
            init();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private Connection getNewConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=qwerty";
        return DriverManager.getConnection(url);
    }

    private void init() throws SQLException {
        connection = getNewConnection();
    }

    private void close() throws SQLException {
        connection.close();
    }

    public String openConnection(){
        try {
            init();
            return "Connecting to the database was successful";
        }catch (SQLException e){
            return e.getMessage();
        }
    }
}
