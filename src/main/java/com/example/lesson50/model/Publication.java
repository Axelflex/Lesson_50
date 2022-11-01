package com.example.lesson50.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Publication {
    private Integer id;
    private Integer user_id;
    private String photo;
    private String Description;
    private LocalDateTime datetimeOfPublication;
}
