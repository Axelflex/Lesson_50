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
    private final UserDAO userDAO;

    public Boolean isLikeExist(String email){
//        if(userDAO.isUserExist(email)){
//            String query = "select * from users u " +
//                    "inner join likes l on u.id = l.user_id " +
//                    "where email = ?";
//            List<User> user = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(User.class), email);
//            return user.size() != 0;
//        }
        return false;
    }
    public void putLike(Integer user_id, Integer publication_id, String datetime){
        String query = "INSERT INTO likes(user_id, publication_id, datetimeOfLike) " +
                "VALUES(?, ?, ?); ";
        jdbcTemplate.update(query, user_id, publication_id, datetime);
    }
    public void removeLike(Integer user_id){
        String query = "delete from likes " +
                "where user_id = ?";
        jdbcTemplate.update(query, user_id);
    }
    public void deleteAll() {
        String query = "delete from likes";
        jdbcTemplate.update(query);
    }
}
