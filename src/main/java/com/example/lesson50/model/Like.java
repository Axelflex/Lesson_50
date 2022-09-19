package com.example.lesson50.model;

import lombok.Data;

@Data
public class Like {
    private User user;
    private Publication publication;
    private String datetimeOfLike;
}
