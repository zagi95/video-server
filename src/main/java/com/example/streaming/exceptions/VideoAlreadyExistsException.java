package com.example.streaming.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Video with that name already exists!")
public class VideoAlreadyExistsException extends RuntimeException{
}
