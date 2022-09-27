package com.example.lesson50.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CommentDAO {
    private final JdbcTemplate jdbcTemplate;

    public void addComment(){
        String query = "INSERT INTO comments(user_id, publication_id, commentText, datetimeOfComment) " +
                "VALUES(?, ?, ?, ?); ";
        jdbcTemplate.update(query);
    }
    public void deleteComment(){
        String query = "delete from comments " +
                "where user_id = ?";
        jdbcTemplate.update(query);
    }
}
