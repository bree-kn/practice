package com.example.practice.jdbcTemplate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
}
