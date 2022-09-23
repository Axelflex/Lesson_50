package com.example.lesson50.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Like {
    private User owner;
    private Publication publication;
    private String datetimeOfLike;
}
