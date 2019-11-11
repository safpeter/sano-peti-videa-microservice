package com.codecool.recommendation.repository;

import com.codecool.recommendation.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RecomRepository extends JpaRepository<Recommendation, Long> {


    List<Recommendation> findByVideoId(Long videoId);

}
