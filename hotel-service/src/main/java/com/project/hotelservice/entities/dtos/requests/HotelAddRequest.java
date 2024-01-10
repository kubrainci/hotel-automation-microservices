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

    @NotBlank(message = "Ülke adı boş bırakılamaz")
    private String country;

    @NotBlank(message = "Otel ismiboş bırakılamaz")
    private String hotelName;

    @NotBlank(message = "Telefon numarası boş bırakılamaz.")
    private String phoneNumber;

    @NotBlank(message = "İnventorykod boş bırakılamaz.")
    @Size(min = 2,max = 5 ,message = "İnventorykod minimum 2 maksimum 3 haneden oluşmak zorundadır.")
    private String inventoryCode;

    @NotBlank(message = "Otelin yıldızı belirtilmek zorundadır.")
    private String star;

     @NotNull(message = "Günlük ücret boş bırakılamaz.")
     @Min(value = 500,message = "Günlük ücret 500 den az olamaz.")
    private Double dailyPrice;

    private Boolean state;
}
