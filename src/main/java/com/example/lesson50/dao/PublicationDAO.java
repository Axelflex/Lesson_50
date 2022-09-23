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
        //шаг первый получить список всех id подписчиков
        //шаг воторой выбрать все публикации у которых owner_id в списке подписчиков полученных в 1 шаге

        //выполнение данного метода не представляется возможным, так как мы не прошли OneToMany и дургие типи связий
        //в java spring
        String query = "select * from publications";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Publication.class));
    }
}
