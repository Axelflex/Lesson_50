package com.example.lesson50.dao;

import com.example.lesson50.model.Publication;
import com.example.lesson50.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PublicationDAO {
    private final JdbcTemplate jdbcTemplate;

    public List<Publication> getAllPub(){
        String query = "select * from publications";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Publication.class));
    }
    public List<Publication> getAllPubsOfFollowers(){
        String query = "select * from publications p " +
                "inner join followers f on p.user_id = f.subscriber_id " +
                "where p.user_id = ?";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Publication.class));
    }
    public void createPub(){
        String query = "INSERT INTO publications(user_id, photo, datetimeOfPublication)" +
                "VALUES(?, ?, ?);";
        jdbcTemplate.update(query);
    }
    public void deletePub(){
        String query = "delete from publications " +
                "where user_id = ?";
        jdbcTemplate.update(query);
    }
}
