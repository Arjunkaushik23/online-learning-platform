package com.example.entity;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Progress {

    private Long id;
    private Long userId;
    private Long courseId;
    private String status;
}
