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


    @GetMapping("/getAll")
    public List<CustomerGetResponse>getAll(){

    return customerService.getAll();
    }


    @PostMapping
    public CustomerAddResponse signIn(@RequestBody @Valid CustomerAddRequest request){
        return customerService.signIn(request);
    }


    @PutMapping
    public CustomerUpdateResponse upDate(@RequestParam String userCode,@RequestBody @Valid CustomerUpdateRequest request){
        return customerService.upDate(userCode,request);
    }

    @DeleteMapping
    public void delete(@RequestParam String userCode){

        customerService.delete(userCode);
    }

    @GetMapping("/getByUserCode")
    public CustomerGetResponse getByUserCode(String userCode){

        return customerService.getByUserCode(userCode);
    }

    @PostMapping("/balanceUp")
    public double balanceUp(@RequestParam String userCode,@RequestParam double balance){
        return customerService.balanceUp(userCode, balance);
    }

    @PostMapping("/balanceDown")
    public  double balanceDown(@RequestParam String userCode,@RequestParam double balance){
        return customerService.balanceDown(userCode, balance);
    }

    @GetMapping("/getBalanceByCustomer")
    public double getBalanceByCustomer(String userCode){
        return customerService.getBalanceByCustomer(userCode);
    }

}
