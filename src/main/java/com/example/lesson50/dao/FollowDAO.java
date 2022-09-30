package com.example.lesson50.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FollowDAO {
    private final JdbcTemplate jdbcTemplate;

    public void subscribe(Integer subscriber_id, Integer ownerOfProfile_id, String datetime){
        String query = "INSERT INTO followers(subscriber_id, ownerOfProfile_id, datetimeOfFollow) " +
                "VALUES(?, ?, ?);";
        jdbcTemplate.update(query, subscriber_id, ownerOfProfile_id, datetime);
    }
    public void unsubscribe(Integer subscriber_id){
        String query = "delete from followers " +
                "where subscriber_id = ?";
        jdbcTemplate.update(query, subscriber_id);
    }
}
