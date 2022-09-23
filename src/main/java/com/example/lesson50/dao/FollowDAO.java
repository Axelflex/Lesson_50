package com.example.lesson50.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FollowDAO {
    private final JdbcTemplate jdbcTemplate;
}
