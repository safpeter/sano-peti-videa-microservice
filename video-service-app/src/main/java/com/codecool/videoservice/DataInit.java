package com.codecool.videoservice;

import com.codecool.videoservice.model.Video;
import com.codecool.videoservice.repository.VideoRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Builder
@Component
public class DataInit implements CommandLineRunner  {

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public void run(String... args) throws Exception {
        videoRepository.save(Video.builder()
                .name("Safri Duo-Played-A-Live")
                .url("https://videa.hu/videok/zene/safri-duo.-played-a-live-dob-klip-koncert-09Nxt8l7qV4QzkjS")
                .build());

        videoRepository.save(Video.builder()
                .name("Viagra Boys-Sports")
                .url("https://www.youtube.com/watch?v=QjL7D33xpS4&list=LLOHLGwK6Wz0OmzjwCI_LJCA&index=42&t=27s")
                .build());

        videoRepository.save(Video.builder()
                .name("Age of Empires sounds remix")
                .url("https://www.youtube.com/V/P3h0ym2s0mE&list=LLOHLGwK6Wz0OmzjwCI_LJCA&index=208")
                .build());

        videoRepository.save(Video.builder()
                .name("Steelers Wheel-Stuck In The Middle With You")
                .url("https://www.youtube.com/watch?v=Ic7Ibl9I5CQ")
                .build());

    }
}
