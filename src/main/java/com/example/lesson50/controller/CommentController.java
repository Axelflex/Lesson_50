package com.example.lesson50.controller;

import com.example.lesson50.dao.CommentDAO;
import com.example.lesson50.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/comments")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CommentController {
    private final CommentDAO commentDAO;
    @GetMapping("/getAllComments")
    public ResponseEntity<List<Comment>> getAllComments(@RequestParam Integer post_id){
        return new ResponseEntity<>(commentDAO.getAllComments(post_id), HttpStatus.OK);
    }

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
