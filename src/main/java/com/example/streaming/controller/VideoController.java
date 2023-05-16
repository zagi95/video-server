package com.example.streaming.controller;

import com.example.streaming.entity.Video;
import com.example.streaming.service.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("video")
@AllArgsConstructor
@CrossOrigin(value = "http://localhost:4200")
public class VideoController {
    private VideoService service;

    @PostMapping()
    public ResponseEntity<String> saveVideo(@RequestParam("file")MultipartFile file, @RequestParam("name") String name) throws IOException{
        service.saveVideo(file, name);
        return ResponseEntity.ok("Success!");
    }

    @GetMapping("{name}")
    public ResponseEntity<Resource> getVideoByName(@PathVariable String name) throws IOException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new ByteArrayResource(service.getVideo(name).getData()));
    }

    @GetMapping
    public List<String> getVideos(){
        return service.getAllVideoNames();
    }
}
