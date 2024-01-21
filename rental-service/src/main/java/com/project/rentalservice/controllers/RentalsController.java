package com.project.rentalservice.controllers;

import com.project.rentalservice.entities.dtos.requests.RentalUpdateRequest;
import com.project.rentalservice.entities.dtos.requests.SubmitRentalDto;
import com.project.rentalservice.entities.dtos.responses.RentalGetResponse;
import com.project.rentalservice.entities.dtos.responses.RentalUpdateResponse;
import com.project.rentalservice.services.abstracts.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rentals")
public class RentalsController {
    private RentalService rentalService;

    @PostMapping("/submitRental")
    public String submitRental(@RequestBody SubmitRentalDto submitRentalDto) {
        return rentalService.submitRental(submitRentalDto);
    }

    @GetMapping("/getAll")
    public  List<RentalGetResponse> getAll(){

        return rentalService.getAll();
    }

    @DeleteMapping("/delete")
    public void delete(int id){
        rentalService.delete(id);
    }

    @PutMapping("/update")
    public RentalUpdateResponse upDate(@RequestParam int id ,@RequestBody RentalUpdateRequest request ){
        return rentalService.upDate(id,request);
    }

   @GetMapping("/getById")
    public RentalGetResponse getById(int id){
        return rentalService.getById(id);
   }


}
