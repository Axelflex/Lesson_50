package com.example.lesson50.model;

import lombok.Data;

@Data
public class Follow {
    private User subscriber;
    private User ownerOfProfile;
    private String dateOfFollow;
}
