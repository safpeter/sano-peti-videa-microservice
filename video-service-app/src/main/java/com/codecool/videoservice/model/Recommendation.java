package com.codecool.videoservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Recommendation {

    private Long id;

    private Integer rating;

    private String comment;



}
