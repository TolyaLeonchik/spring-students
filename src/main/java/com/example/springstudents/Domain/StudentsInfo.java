package com.example.springstudents.Domain;

import lombok.Data;

@Data
public class StudentsInfo {

    private Integer id;
    private String firstName;
    private String lastName;
    private String speciality;
    private FormOfEducation form;
}
