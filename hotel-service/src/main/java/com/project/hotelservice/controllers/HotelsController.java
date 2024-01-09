package com.project.hotelservice.controllers;

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

    @GetMapping("/deneme")
    public String deneme(){
        return "deneme";
    }

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
    public  void delete(@RequestParam String inventoryCode){
        hotelService.delete(inventoryCode);
    }

    @GetMapping("/getByInvCode")
    public HotelGetResponse getByInvCode(@RequestParam String inventoryCode){
      return hotelService.getByInvCode(inventoryCode);
    }


}
