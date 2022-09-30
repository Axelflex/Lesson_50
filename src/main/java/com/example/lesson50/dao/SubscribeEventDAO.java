package com.example.lesson50.dao;

import com.example.lesson50.model.SubscribeEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SubscribeEventDAO {
    private final JdbcTemplate jdbcTemplate;

    public Optional<SubscribeEvent> findById(Long id){
        return Optional.empty();
    }

    public Optional<SubscribeEvent> findByEmail(String email){
        return Optional.empty();
    }

    public Optional<SubscribeEvent> findByEmailAndEventId(String email, Long eventId){
        String sql = "select * from " +
                "subscriber_event s, event e " +
                "where s.email = ? " +
                "and s.even_id = ?;";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(SubscribeEvent.class), email, eventId));
    }

    public Long createSub(String email, Long eventId){
        String sql = "insert into subscriber_event(event_id, email, register_date_time) " +
                "values(?, ?, ?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, new String[]{"id"});
            ps.setLong(1, eventId);
            ps.setString(2, email);
            ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            return ps;
        }, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    public void deleteSub(Long id){

    }
}
