package com.example.lesson50.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Follow {
    private Integer subscriber_id;
    private Integer ownerOfProfile_id;
    private String dateOfFollow;
}
