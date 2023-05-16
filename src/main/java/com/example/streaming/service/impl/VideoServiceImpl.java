package com.example.streaming.service.impl;

import com.example.streaming.entity.Video;
import com.example.streaming.exceptions.VideoAlreadyExistsException;
import com.example.streaming.exceptions.VideoNotFoundException;
import com.example.streaming.repository.VideoRepository;
import com.example.streaming.service.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class VideoServiceImpl implements VideoService {
    private VideoRepository repository;
    @Override
    public Video getVideo(String name) throws VideoNotFoundException {
        if (!repository.existsByName(name)){
            throw new VideoNotFoundException();
        }
        return repository.findByName(name);
    }

    @Override
    public void saveVideo(MultipartFile file, String name) throws RuntimeException, IOException {
        if (repository.existsByName(name)){
            throw new VideoAlreadyExistsException();
        }
        repository.save(
                new Video(name, file.getBytes())
        );
    }

    @Override
    public List<String> getAllVideoNames() {
        return repository.getAllEntryNames();
    }
}
