package com.example.lesson50.controller;

import com.example.lesson50.dao.FollowDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/followers")
@RequiredArgsConstructor
public class FollowController {
    private final FollowDAO followDAO;

    @PostMapping("/subscribe")
    public void subscribe(@RequestParam Integer subscriber_id,
                          @RequestParam Integer ownerOfProfile_id,
                          @RequestParam String datetime){
        followDAO.subscribe(subscriber_id, ownerOfProfile_id, datetime);
    }
    @PostMapping("/unsubscribe")
    public void unsubscribe(@RequestParam Integer subscriber_id){
        followDAO.unsubscribe(subscriber_id);
    }

}
