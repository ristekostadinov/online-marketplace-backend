package com.example.demo.service;

import com.example.demo.model.Place;
import com.example.demo.model.exception.PlaceNotFoundException;
import com.example.demo.repository.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {
    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository){
        this.placeRepository = placeRepository;
    }

    public Place findById(Long id){
        return this.placeRepository.findById(id).orElseThrow(()-> new PlaceNotFoundException("This place id doesn't exist in database"));
    }

    public List<Place> findAll(){
        return this.placeRepository.findAll();
    }
}
