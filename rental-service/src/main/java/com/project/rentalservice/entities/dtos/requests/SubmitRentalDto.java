package com.project.rentalservice.entities.dtos.requests;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "İnventory kod boş bırakılamaz.")
    private  String inventoryCode;

    private int customerId;

    @NotBlank(message = "Kiralamanın son tarihi boş bırakılamaz.")
    private LocalDate endDate;
}
