package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Assignment {

    private Long id;
    private Long userId;
    private String assignmentName;
    private Long courseId;
    private Long progressId;
    private String description;

}
