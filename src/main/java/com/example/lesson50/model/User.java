package com.example.lesson50.model;

import lombok.Data;

@Data
public class User {
    private String nickName;
    private String email;
    private String password;
    private int publications;
    private int followers;
    private int subscriptions;
}
