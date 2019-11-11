package com.codecool.recommendation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Recommendation {

    @Id
    @GeneratedValue
    private Long id;

    @Column(scale = 1-5)
    private int rating;

    private String comment;

    private Long videoId;
}
