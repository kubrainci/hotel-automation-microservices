package com.project.hotelservice.services.concretes;

import com.project.hotelservice.core.exceptions.BusinessException;
import com.project.hotelservice.entities.Hotel;
import com.project.hotelservice.entities.dtos.requests.HotelAddRequest;
import com.project.hotelservice.entities.dtos.requests.HotelUpdateRequest;
import com.project.hotelservice.entities.dtos.responses.HotelAddResponse;
import com.project.hotelservice.entities.dtos.responses.HotelGetResponse;
import com.project.hotelservice.entities.dtos.responses.HotelUpdateResponse;
import com.project.hotelservice.repositories.HotelRepository;
import com.project.hotelservice.services.abstracts.HotelService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelManager implements HotelService {
    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;
    private final MessageSource messageSource;

    @Override
    public List<HotelGetResponse> getAll() {

        List<Hotel> hotels = hotelRepository.findAll();
        List<HotelGetResponse> hotelGetResponses =
                hotels.stream().map(item -> modelMapper.map(item, HotelGetResponse.class)).toList();

        return hotelGetResponses;
    }

    @Override
    public HotelAddResponse add(HotelAddRequest request) {
        hotelWithSamePhoneNumberShouldNotExist(request.getPhoneNumber());
        hotelWithSameInventoryCodeShouldNotExist(request.getInventoryCode());
        Hotel hotelForAutoMapping = modelMapper.map(request, Hotel.class);
        hotelForAutoMapping = hotelRepository.save(hotelForAutoMapping);
        HotelAddResponse hotelAddResponse =
                modelMapper.map(hotelForAutoMapping, HotelAddResponse.class);

        return hotelAddResponse;
    }


    @Override
    public HotelUpdateResponse upDate(String inventoryCode, HotelUpdateRequest request) {
        Hotel hotel = hotelRepository.getReferenceByInventoryCode(inventoryCode);
        modelMapper.map(request, hotel);
        hotel = hotelRepository.save(hotel);
        HotelUpdateResponse hotelUpdateResponse =
                modelMapper.map(hotel, HotelUpdateResponse.class);
        return hotelUpdateResponse;
    }

    @Override
    public void delete(int id) {

        hotelRepository.deleteById(id);
    }


    @Override
    public HotelGetResponse getByInventoryCode(String inventoryCode) {
        Hotel hotel = hotelRepository.getReferenceByInventoryCode(inventoryCode);
        modelMapper.map(inventoryCode, hotel);
        hotel = hotelRepository.save(hotel);

        HotelGetResponse hotelGetResponse =
                modelMapper.map(hotel, HotelGetResponse.class);

        return hotelGetResponse;
    }


    private void hotelWithSamePhoneNumberShouldNotExist(String phoneNumber) {

        Hotel hotelWithSamePhoneNumber = hotelRepository.findByPhoneNumber(phoneNumber);
        if (hotelWithSamePhoneNumber != null) {

            throw new BusinessException(
                    messageSource.getMessage(
                            "hotelWithSamePhoneNumberShouldNotExist", null, LocaleContextHolder.getLocale()));
        }


    }
    private void hotelWithSameInventoryCodeShouldNotExist(String inventoryCode) {

        Hotel  hotelWithSameInventoryCode=hotelRepository.findByInventoryCode(inventoryCode);

        if(hotelWithSameInventoryCode !=null){
            throw new BusinessException(messageSource.getMessage(
                    "hotelWithSameInventoryCodeShouldNotExist",null,LocaleContextHolder.getLocale()));
        }
    }


}
