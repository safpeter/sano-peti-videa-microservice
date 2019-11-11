package com.codecool.videoservice.repository;

import com.codecool.videoservice.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {

    List<Video> findAll();

    Video getById(Long id);

}
