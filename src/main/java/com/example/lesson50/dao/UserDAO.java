package com.example.lesson50.dao;

import com.example.lesson50.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserDAO {
    private final JdbcTemplate jdbcTemplate;

    public void addUser(String nickname, String name, String email, String password){
        String query = "INSERT INTO users(nickname, name, email, password) " +
               "VALUES(?, ?, ?, ?) ";
        jdbcTemplate.update(query, nickname, name, email, password);
    }
    public void deleteAll() {
        String query = "delete from users";
        jdbcTemplate.update(query);
    }

    public Boolean isUserExist(String email){
        String query = "select * from users " +
                "where email = ?";
        List<User> user = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(User.class), email);
        return user.size() != 0;
    }

    public List<User> getAllUsers(){
        String query = "select * from users";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(User.class));
    }
    public List<User> getUserByNickname(String nickname){
        String query = "select * from users " +
                "where nickname = ?";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(User.class), nickname);
    }
    public List<User> getUserByEmail(String email){
        String query = "select * from users " +
                "where email = ?";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(User.class), email);
    }
    public List<User> getUserByName(String name){
        String query = "select * from users " +
                "where name = ?";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(User.class), name);
    }

}
