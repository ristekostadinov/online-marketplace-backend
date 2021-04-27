package com.example.demo.controller;

import com.example.demo.model.Place;
import com.example.demo.service.PlaceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/places")
public class PlaceController {
    private final PlaceService placeService;

    public PlaceController(PlaceService placeService){
        this.placeService = placeService;
    }

    @GetMapping()
    public List<Place> listPlaces(){
        return this.placeService.findAll();
    }
}
