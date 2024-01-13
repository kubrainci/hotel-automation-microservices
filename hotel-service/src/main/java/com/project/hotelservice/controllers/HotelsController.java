package com.project.hotelservice.controllers;

import com.project.hotelservice.entities.Hotel;
import com.project.hotelservice.entities.dtos.requests.HotelAddRequest;
import com.project.hotelservice.entities.dtos.requests.HotelUpdateRequest;
import com.project.hotelservice.entities.dtos.responses.HotelAddResponse;
import com.project.hotelservice.entities.dtos.responses.HotelGetResponse;
import com.project.hotelservice.entities.dtos.responses.HotelUpdateResponse;
import com.project.hotelservice.repositories.HotelRepository;
import com.project.hotelservice.services.abstracts.HotelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/hotels")
public class HotelsController {
    private final HotelService hotelService;
    private final HotelRepository hotelRepository;


    @GetMapping("/getAll")
    public List<HotelGetResponse>getAll(){
        return hotelService.getAll();
    }

    @PostMapping("/add")
    public  HotelAddResponse add(@RequestBody @Valid HotelAddRequest request){

        return hotelService.add(request);
    }

    @PutMapping("/upDate")
    public HotelUpdateResponse upDate(@RequestParam String inventoryCode , @RequestBody @Valid HotelUpdateRequest request){
        return hotelService.upDate(inventoryCode,request);
    }

    @DeleteMapping("/delete")
    public  void delete(@RequestParam int id){

        hotelService.delete(id);
    }

    @GetMapping("/getByInvCode")
    public HotelGetResponse getByInventoryCode(@RequestParam String inventoryCode){
      return hotelService.getByInventoryCode(inventoryCode);
    }

    @GetMapping("/getByStar")
    public  List<Hotel>searchStar(@RequestParam String star){
            List<Hotel>hotels=hotelRepository.searchStar(star);
        return hotels;
    }

    @GetMapping("/getByCountry")
    public List<Hotel>searchCountry(@RequestParam("name") String country){
        List<Hotel>hotels=hotelRepository.searchCountry(country);
        return hotels;
    }
     @GetMapping("/getByDailyPrice")
     public List<Hotel>searchDailyPrice(@RequestParam double dailyPrice){
         List<Hotel>hotels=hotelRepository.searchDailyPrice(dailyPrice);
         return hotels;
     }

    @GetMapping("getByHotelName")
    public List<Hotel>searchHotelName(@RequestParam("name") String HotelName){
        List<Hotel>hotels=hotelRepository.searchHotelName(HotelName);
        return hotels;
    }

    @GetMapping("getFromSmallToBigByDailyPrice")
    public List<Hotel>searchFromBigToSmall(@RequestParam double dailyPrice){
        List<Hotel>hotels=hotelRepository.searchFromSmallToBig(dailyPrice);
        return hotels;
    }

    @GetMapping("getAZByHotelName")
    public List<Hotel>searchAZHotelName(@RequestParam String hotelName){
        List<Hotel>hotels=hotelRepository.searchAZHotelName(hotelName);
        return hotels;
    }


    @GetMapping("getAZByCountry")
    public List<Hotel>searchAZCountry(@RequestParam String country){
        List<Hotel>hotels=hotelRepository.searchAZCountry(country);
        return hotels;
    }

    @GetMapping("getFromBigToSmallByStar")
    public List<Hotel>searchFromBigToSmall(@RequestParam int star){
        List<Hotel>hotels=hotelRepository.searchFromBigToSmall(star);
        return hotels;
    }
}
