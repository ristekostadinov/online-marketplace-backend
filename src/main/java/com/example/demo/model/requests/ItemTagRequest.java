package com.example.demo.model.requests;
import lombok.Data;


@Data
public class ItemTagRequest {
    private Long id;
    private Long itemId;
    private Long tagId;
}
