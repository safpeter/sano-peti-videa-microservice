package com.codecool.recommendation.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class IncomingRecommendationService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${videoservice.url}")
    private String baseUrl;



}
