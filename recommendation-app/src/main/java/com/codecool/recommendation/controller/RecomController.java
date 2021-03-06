package com.codecool.recommendation.controller;


import com.codecool.recommendation.model.NewRecommendation;
import com.codecool.recommendation.model.Recommendation;
import com.codecool.recommendation.repository.RecomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/recommendations")
public class RecomController {

    @Autowired
    private RecomRepository recomRepository;

    @GetMapping("/{videoId}")
    public List<Recommendation> getRecommendations(@PathVariable("videoId") Long videoId) {
        return recomRepository.findByVideoId(videoId);
    }

    @PostMapping("/newrecommendation/{videoId}")
    public boolean uploadRecommendation(@PathVariable("videoId") Long videoId, @RequestBody Recommendation recommendation) {
        if(recommendation.getRating() == 0 ){
            return false;
        } else {
            recomRepository.save(recommendation);
            return true;
        }
    }

}
