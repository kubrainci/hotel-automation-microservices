package com.project.customerservice.controllers;

import com.project.customerservice.entities.dtos.requests.CustomerAddRequest;
import com.project.customerservice.entities.dtos.responses.CustomerAddResponse;
import com.project.customerservice.entities.dtos.responses.CustomerGetResponse;
import com.project.customerservice.services.abstracts.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/customers")
public class CustomersController {
    private final CustomerService customerService;

    @GetMapping
    public String deneme(){
        return "deneme";

    }
    @DeleteMapping
    public void delete(@RequestParam int id){

        customerService.delete(id);
    }

    @PostMapping
    public CustomerAddResponse signIn(@RequestBody @Valid CustomerAddRequest request){
        return customerService.signIn(request);
    }

    @GetMapping("/getAll")
    public List<CustomerGetResponse>getAll(){
        return customerService.getAll();
    }

}
