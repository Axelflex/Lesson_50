package com.example.lesson50.dao;

import com.example.lesson50.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class LikeDAO {

    private final JdbcTemplate jdbcTemplate;

    public Boolean isLikeExist(User user){
        //шаг первый нужно получить user_id
        //шаг воторой полчить publications_id
        //выполнить проверку на то что они не null и если true значит лайк есть, если false то лайка нет
        //под постом от конкрнетного юзера

        //выполнение данного метода не представляется возможным, так как мы не прошли OneToMany и дургие типи связий
        //в java spring
        return null;
    }
}
