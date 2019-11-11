package com.codecool.videoservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewRecommendation {

    private String comment;

    private int rating;

    private Long videoId;
}
