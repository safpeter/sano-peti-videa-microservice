package com.codecool.videoservice.controller;


import com.codecool.videoservice.model.NewRecommendation;
import com.codecool.videoservice.model.Recommendation;
import com.codecool.videoservice.model.UpdateVideo;
import com.codecool.videoservice.model.Video;
import com.codecool.videoservice.repository.VideoRepository;

import com.codecool.videoservice.service.RecommendationCallerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${recomservice.url}")
    String recomUrl;

    @Autowired
    HttpHeaders httpHeaders;

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private RecommendationCallerService recommendationCallerService;

    @GetMapping("/all")
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    @GetMapping("/video/{id}")
    public Video getVideoAndRecommendation(@PathVariable Long id) {
        return videoRepository.getById(id);
    }

    @GetMapping("/recommendation/{id}")
    public Recommendation[] getRecommendation(@PathVariable Long id){
        return recommendationCallerService.getRecommendations(id);
    }

    @PostMapping("/add")
    public String addNewVideo(@RequestBody UpdateVideo updateVideo) {
        videoRepository.save(Video.builder()
                .name(updateVideo.getName())
                .url(updateVideo.getUrl())
                .build());
        return "Video uploaded succesfully!";
    }

    @PostMapping("/newrecommendation/{videoId}")
    public boolean addNewRecommendation(@PathVariable("videoId")Long videoId,@RequestBody NewRecommendation recommendation){
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        recommendation.setVideoId(videoId);
        HttpEntity<NewRecommendation> entity = new HttpEntity<>(recommendation, httpHeaders);
        System.out.println(recommendation);
        ResponseEntity<Boolean> s = restTemplate.exchange(recomUrl + "/newrecommendation/" + videoId, HttpMethod.POST, entity, Boolean.class);
        return s.getBody();
    }


}
