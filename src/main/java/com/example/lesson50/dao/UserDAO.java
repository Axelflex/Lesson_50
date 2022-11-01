package com.example.lesson50.dao;

import com.example.lesson50.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDAO {
    private final JdbcTemplate jdbcTemplate;

    public ResponseEntity<?> addUser(String nickname, String name, String email, String password){
        String query = "INSERT INTO users(nickname, name, email, password, enabled) " +
               "VALUES(?, ?, ?, ?, true) ";
        return new ResponseEntity<>(jdbcTemplate.update(query, nickname, name, email, password), HttpStatus.OK);
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
    public Optional<User> getUserByEmail(String email){
        String query = "select * from users " +
                "where email = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(User.class), email));
    }
    public List<User> getUserByName(String name){
        String query = "select * from users " +
                "where name = ?";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(User.class), name);
    }

    public void save (User user) {
        String sql = "insert into users (email, name, password, nickname, enabled) " +
                "values (?, ?, ?, ?, true);";
        jdbcTemplate.update(sql, user.getEmail(), user.getName(), user.getPassword(), user.getNickname());
    }
}
