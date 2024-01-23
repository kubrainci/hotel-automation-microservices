package com.project.rentalservice.entities.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RentalUpdateRequest {

    @NotBlank(message = "Kiralama tarihi boş bırakılamaz.")
    LocalDate rentalDate;

    @NotBlank(message = "İnventory kod boş bırakılamaz.")
    private String inventoryCode;

}
