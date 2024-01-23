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

    @NotBlank(message = "{RentalDateCannotBeLeftBlank}")
    LocalDate rentalDate;

    @NotBlank(message = "{InventoryCodeCannotBeLeftBlank}")
    private String inventoryCode;

}
