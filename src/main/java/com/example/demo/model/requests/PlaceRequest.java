package com.example.demo.model.requests;

import lombok.Data;

@Data
public class PlaceRequest {
    private Long id;
    private String name;
    private String zipCode;
}
