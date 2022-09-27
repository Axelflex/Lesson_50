package com.example.lesson50.controller;

import com.example.lesson50.dao.LikeDAO;
import com.example.lesson50.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController("/likes")
@RequiredArgsConstructor
public class LikeController {

    private final LikeDAO likeDAO;
    @GetMapping("/isLikeExist")
    public ResponseEntity<Boolean> isLikeExist(){
        return new ResponseEntity<>(likeDAO.isLikeExist(), HttpStatus.OK);
    }
    @PostMapping("/deleteLike")
    public void deleteLike(){
        likeDAO.removeLike();
    }
    @PostMapping("/putLike")
    public void putLike(){
        likeDAO.putLike();
    }
}
