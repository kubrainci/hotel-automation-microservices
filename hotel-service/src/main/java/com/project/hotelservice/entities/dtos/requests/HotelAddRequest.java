package com.project.hotelservice.entities.dtos.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class HotelAddRequest {

    @NotBlank(message = "{CountryNameCannotBeLeftBlank}")
    private String country;

    @NotBlank(message = "{HotelNameCannotBeLeftBlank}")
    private String hotelName;

    @NotBlank(message = "{PhoneNumberCannotBeLeftBlank}")
    private String phoneNumber;

    @NotBlank(message = "{InventoryCodeCannotBeLeftBlank}")
    @Size(min = 2,max = 5 ,message = "{InvCodeMustMatchTheNumberOfCharacters}")
    private String inventoryCode;

    @NotBlank(message = "{HotelStarsCannotBeLeftBlank}")
    private String star;

     @NotNull(message = "{DailyPriceCannotBeLeftBlank}")
     @Min(value = 500,message = "{MinimumPriceOfDailyWage}")
    private Double dailyPrice;

    private Boolean state;
}
