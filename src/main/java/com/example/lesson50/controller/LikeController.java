package com.example.lesson50.controller;

import com.example.lesson50.dao.LikeDAO;
import com.example.lesson50.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController("/likes")
@RequiredArgsConstructor
public class LikeController {

    private final LikeDAO likeDAO;
    @GetMapping("/isLikeExist")
    public ResponseEntity<Boolean> isLikeExist(@RequestParam String email){
        return new ResponseEntity<>(likeDAO.isLikeExist(email), HttpStatus.OK);
    }
    @PostMapping("/deleteLike")
    public void deleteLike(@RequestParam Integer user_id){
        likeDAO.removeLike(user_id);
    }
    @PostMapping("/putLike")
    public void putLike(@RequestParam Integer user_id,
                        @RequestParam Integer publication_id,
                        @RequestParam String datetime){
        likeDAO.putLike(user_id, publication_id, datetime);
    }
}
