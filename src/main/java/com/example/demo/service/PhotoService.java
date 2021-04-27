package com.example.demo.service;

import com.example.demo.repository.PhotoRepository;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {
    private final PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository){
        this.photoRepository = photoRepository;
    }

}
