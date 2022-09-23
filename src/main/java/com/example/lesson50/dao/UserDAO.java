package com.example.lesson50.dao;

import com.example.lesson50.model.Customer;
import com.example.lesson50.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class UserDAO {
    private final JdbcTemplate jdbcTemplate;

    public Boolean isUserExist(String email){
        String query = String.format("select * from users" +
                "where email = '%s'", email);
        List<User> user = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(User.class));
        return user.size() != 0;
    }

    public List<User> getAllUsers(){
        String query = "select * from users";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(User.class));
    }
    public List<User> getUserByNickname(String nickname){
        String query = String.format("select * from users " +
                "where nickname = '%s'", nickname);
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(User.class));
    }
    public List<User> getUserByEmail(String email){
        String query = String.format("select * from users " +
                "where email = '%s'", email);
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(User.class));
    }
    public List<User> getUserByName(String userName){
        String query = String.format("select * from users " +
                "where name = '%s'", userName);
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(User.class));
    }

}
