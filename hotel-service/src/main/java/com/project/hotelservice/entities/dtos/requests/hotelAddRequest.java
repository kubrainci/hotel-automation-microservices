package com.project.hotelservice.entities.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class hotelAddRequest {

    private String country;

    private String hotelName;

    private String phoneNumber;

    private String inventoryCode;

    private String star;

    private Double dailyPrice;

    private Boolean state;
}
