package com.project.customerservice.controllers;

import com.project.customerservice.entities.dtos.requests.CustomerAddRequest;
import com.project.customerservice.entities.dtos.requests.CustomerUpdateRequest;
import com.project.customerservice.entities.dtos.responses.CustomerAddResponse;
import com.project.customerservice.entities.dtos.responses.CustomerGetResponse;
import com.project.customerservice.entities.dtos.responses.CustomerUpdateResponse;
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

//    @GetMapping
//    public String deneme(){
//        return "deneme";
//
//    }
    @GetMapping("/getAll")
    public List<CustomerGetResponse>getAll(){

    return customerService.getAll();
    }


    @PostMapping
    public CustomerAddResponse signIn(@RequestBody @Valid CustomerAddRequest request){
        return customerService.signIn(request);
    }


    @PutMapping
    public CustomerUpdateResponse upDate(@RequestParam String id,@RequestBody @Valid CustomerUpdateRequest request){
        return customerService.upDate(id,request);
    }

    @DeleteMapping
    public void delete(@RequestParam String id){

        customerService.delete(id);
    }

    @GetMapping("/getById")
    public CustomerGetResponse getById(String id){
        return customerService.getById(id);
    }

    @PostMapping("/balanceUp")
    public double balanceUp(@RequestParam String inventoryCode,@RequestParam double balance){
        return customerService.balanceUp(inventoryCode, balance);
    }

    @PostMapping("/balanceDown")
    public  double balanceDown(@RequestParam String inventoryCode,@RequestParam double balance){
        return customerService.balanceDown(inventoryCode, balance);
    }

    @GetMapping("/getByInvCode")
    public  CustomerGetResponse getBalanceByCustomer(String inventoryCode){
        return customerService.getBalanceByCustomer(inventoryCode);
    }

}
