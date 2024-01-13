package com.project.hotelservice.entities.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class HotelUpdateResponse {

    private String country;

    private String hotelName;

    private String phoneNumber;

    private String inventoryCode;

    private int star;

    private Double dailyPrice;

    private Boolean state;
}
