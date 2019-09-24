package com.example.practice.jdbcTemplate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
public class emp {
    private int id;
    private String name;
    private String deptId;
    private double salary;
}
