package com.example.lesson50.controller;

import com.example.lesson50.dao.CommentDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentDAO commentDAO;
    @PostMapping("/deleteComment")
    public void deleteComment(){
        commentDAO.deleteComment();
    }
    @PostMapping("/addComment")
    public void addComment(){
        commentDAO.addComment();
    }

}
