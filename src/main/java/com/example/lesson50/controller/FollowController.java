package com.example.lesson50.controller;

import com.example.lesson50.dao.FollowDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/followers")
@RequiredArgsConstructor
public class FollowController {
    private final FollowDAO followDAO;

    @PostMapping("/subscribe")
    public void subscribe(){
        followDAO.subscribe();
    }
    @PostMapping("/unsubscribe")
    public void unsubscribe(){
        followDAO.unsubscribe();
    }

}
