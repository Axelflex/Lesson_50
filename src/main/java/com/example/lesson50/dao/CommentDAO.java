package com.example.lesson50.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CommentDAO {
    private final JdbcTemplate jdbcTemplate;

    public void addComment(Integer user_id, Integer publication_id, String commentText, String datetime){
        String query = "INSERT INTO comments(user_id, publication_id, commentText, datetimeOfComment) " +
                "VALUES(?, ?, ?, ?); ";
        jdbcTemplate.update(query, user_id, publication_id, commentText, datetime);
    }
    public void deleteComment(Integer user_id){
        String query = "delete from comments " +
                "where user_id = ?";
        jdbcTemplate.update(query, user_id);
    }
}
