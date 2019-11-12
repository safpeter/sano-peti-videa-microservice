package com.codecool.videoservice;

import com.codecool.videoservice.model.Video;
import com.codecool.videoservice.repository.VideoRepository;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
@Slf4j
@Builder
@Component
public class DataInit implements CommandLineRunner  {

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public void run(String... args)  {
        if(videoRepository.existsById(1L)){
            log.info("Nothing to update");
        } else {
            videoRepository.save(Video.builder()
                    .name("Safri Duo-Played-A-Live")
                    .url("https://videa.hu/videok/zene/safri-duo.-played-a-live-dob-klip-koncert-09Nxt8l7qV4QzkjS")
                    .build());

            videoRepository.save(Video.builder()
                    .name("Viagra Boys-Sports")
                    .url("https://videa.hu/videok/zene/viagra-boys-sports-7KhJOSpZD6W6N90R")
                    .build());


            videoRepository.save(Video.builder()
                    .name("Steelers Wheel-Stuck In The Middle With You")
                    .url("https://indavideo.hu/video/Stealers_Wheel_-_Stuck_In_The_Middle_With_You")
                    .build());
        }

    }
}
