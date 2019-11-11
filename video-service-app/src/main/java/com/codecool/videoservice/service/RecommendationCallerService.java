package com.codecool.videoservice.service;

import com.codecool.videoservice.model.Recommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class RecommendationCallerService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${recomservice.url}")
    private String baseUrl;

    public Recommendation[] getRecommendations(Long videoId) {
        ResponseEntity<Recommendation[]> response = restTemplate.getForEntity(baseUrl + videoId, Recommendation[].class);
        return response.getBody();
    }


}
