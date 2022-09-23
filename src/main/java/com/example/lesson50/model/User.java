package com.example.lesson50.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String nickname;
    private String name;
    private String email;
    private String password;
    private List<Publication> publications;
    private Integer publicationsCount;
    private Integer followers;
    private Integer subscriptions;
}
