package com.example.demo.model.requests;

import lombok.Data;


@Data
public class SubscriberRequest {
    private Long id;
    private String fistName;
    private String lastName;
    private String email;
    private String phone;
}
