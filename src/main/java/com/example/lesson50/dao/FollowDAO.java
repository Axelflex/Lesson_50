package com.example.lesson50.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FollowDAO {
    private final JdbcTemplate jdbcTemplate;

    public void subscribe(){
        String query = "INSERT INTO followers(subscriber_id, ownerOfProfile_id, datetimeOfFollow) " +
                "VALUES(?, ?, ?);";
        jdbcTemplate.update(query);
    }
    public void unsubscribe(){
        String query = "delete from followers " +
                "where subscriber_id = ?";
        jdbcTemplate.update(query);
    }
}
