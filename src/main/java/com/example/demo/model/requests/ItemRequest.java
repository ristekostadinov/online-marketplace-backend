package com.example.demo.model.requests;

import lombok.Data;


@Data
public class ItemRequest {
    private Long id;
    private String name;
    private int salePrice;
    private int oldPrice;
    private Long categoryId;
}
