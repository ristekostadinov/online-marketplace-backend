package com.example.demo.model.requests;

import com.example.demo.model.enumeration.Status;
import lombok.Data;


import java.time.ZonedDateTime;

@Data
public class SaleRequest {
    private Long id;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private Long marketId;
    private Long itemId;
    private Status status;
}
