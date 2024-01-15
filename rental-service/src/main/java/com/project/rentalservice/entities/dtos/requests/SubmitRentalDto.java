package com.project.rentalservice.entities.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubmitRentalDto {

    private  String rentalCode;

    private int customerId;

    private LocalDate endDate;
}
