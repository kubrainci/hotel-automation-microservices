package com.project.customerservice.controllers;

import com.project.customerservice.services.abstracts.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/customers")
public class CustomersController {

    @GetMapping
    public String deneme(){
        return "deneme";

    }
}
