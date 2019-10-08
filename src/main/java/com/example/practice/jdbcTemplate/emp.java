package com.example.practice.jdbcTemplate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class emp implements Serializable {
    private int id;
    private String name;
    private String deptId;
    private double salary;
}
