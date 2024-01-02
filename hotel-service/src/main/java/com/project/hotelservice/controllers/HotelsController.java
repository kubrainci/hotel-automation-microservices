package com.project.hotelservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/hotels")
public class HotelsController {

    @GetMapping("/deneme")
    public String deneme(){
        return "deneme";
    }
}
