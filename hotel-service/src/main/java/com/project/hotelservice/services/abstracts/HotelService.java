package com.project.hotelservice.services.abstracts;

import com.project.hotelservice.entities.dtos.requests.HotelAddRequest;
import com.project.hotelservice.entities.dtos.requests.HotelUpdateRequest;
import com.project.hotelservice.entities.dtos.responses.HotelAddResponse;
import com.project.hotelservice.entities.dtos.responses.HotelGetResponse;
import com.project.hotelservice.entities.dtos.responses.HotelUpdateResponse;

import java.util.List;

public interface HotelService  {

    List<HotelGetResponse>getAll();

    HotelAddResponse add(HotelAddRequest request);

    HotelUpdateResponse upDate(String inventoryCode, HotelUpdateRequest request);

    void delete(int id);

    HotelGetResponse getByInventoryCode(String inventoryCode);







}
