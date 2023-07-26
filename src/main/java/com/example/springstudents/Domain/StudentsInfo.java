package com.example.springstudents.domain;

import lombok.Data;

import java.time.DayOfWeek;

@Data
public class EmployeeInfo {

    private Integer id;
    private String firstName;
    private String lastName;
    private Post post;
    private DayOfWeek day;
    private Shift shift;

    public EmployeeInfo(Integer id, String firstName, String lastName, Post post, DayOfWeek day, Shift shift) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.post = post;
        this.day = day;
        this.shift = shift;
    }
}
