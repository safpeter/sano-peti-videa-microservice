package com.codecool.recommendation;


import com.codecool.recommendation.repository.RecomRepository;
import com.codecool.recommendation.model.Recommendation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataInit implements CommandLineRunner {

    @Autowired
    RecomRepository recomRepository;


    @Override
    @Profile("production")
    public void run(String... args) throws Exception {
        recomRepository.save(Recommendation.builder()
                .rating(5)
                .comment("Thumbs up if you're watching this in 2019!")
                .videoId(1L)
                .build());

        recomRepository.save(Recommendation.builder()
                .rating(5)
                .comment("...Getting High in the morning,buying things on the internet..Sports!!")
                .videoId(2L)
                .build());

        recomRepository.save(Recommendation.builder()
                .rating(2)
                .comment("They were so much better back in the 80's.")
                .videoId(3L)
                .build());

        recomRepository.save(Recommendation.builder()
                .rating(4)
                .comment("Reservoir Dogs brought me here.")
                .videoId(3L)
                .build());
    }

}
