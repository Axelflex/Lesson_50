package com.example.lesson50.controller;

import com.example.lesson50.dao.CommentDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentDAO commentDAO;
    @PostMapping("/deleteComment")
    public void deleteComment(@RequestParam Integer user_id){
        commentDAO.deleteComment(user_id);
    }
    @PostMapping("/addComment")
    public void addComment(@RequestParam Integer user_id,
                           @RequestParam Integer publication_id,
                           @RequestParam String commentText,
                           @RequestParam String datetime){
        commentDAO.addComment(user_id, publication_id, commentText, datetime);
    }

}
