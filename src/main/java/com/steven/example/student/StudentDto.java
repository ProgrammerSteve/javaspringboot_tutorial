package com.steven.example.student;


import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        @NotEmpty(message = "Firstname should ne be empty")
        String firstname,
        @NotEmpty(message = "Lastname should ne be empty")
        String lastname,

        String email,
        Integer schoolId
) {}
