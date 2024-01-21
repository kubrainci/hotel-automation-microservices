package com.project.rentalservice.entities.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalUpdateResponse {

    LocalDate rentalDate;

    private String inventoryCode;
}
