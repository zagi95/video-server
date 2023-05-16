package com.example.streaming.service;

import com.example.streaming.entity.Video;
import com.example.streaming.exceptions.VideoNotFoundException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface VideoService {
    Video getVideo(String name) throws IOException;
    void saveVideo(MultipartFile file, String name) throws RuntimeException, IOException;
    List<String> getAllVideoNames();
}
