package com.codecool.videoservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Import;

import javax.persistence.*;
import java.net.URL;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Video {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    @Column(nullable = false)
    private String url;

}
