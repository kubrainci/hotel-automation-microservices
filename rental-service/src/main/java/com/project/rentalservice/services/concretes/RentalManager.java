package com.project.rentalservice.services.concretes;

import com.project.rentalservice.entities.Rental;
import com.project.rentalservice.entities.dtos.requests.RentalUpdateRequest;
import com.project.rentalservice.entities.dtos.requests.SubmitRentalDto;
import com.project.rentalservice.entities.dtos.responses.RentalGetResponse;
import com.project.rentalservice.entities.dtos.responses.RentalUpdateResponse;
import com.project.rentalservice.repositories.RentalRepository;
import com.project.rentalservice.services.abstracts.RentalService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class RentalManager implements RentalService {

    private  final RentalRepository rentalRepository;
    private final ModelMapper modelMapper;


    @Override
    public String submitRental(SubmitRentalDto submitRentalDto) {
        return null;
    }

    @Override
    public void delete(int id) {
        rentalRepository.deleteById(id);

    }

    @Override
    public RentalUpdateResponse upDate(int id, RentalUpdateRequest request) {
        Rental rental = rentalRepository.getReferenceById(id);
        modelMapper.map(request, rental);
        rental = rentalRepository.save(rental);
        RentalUpdateResponse rentalUpdateResponse = modelMapper.map(rental, RentalUpdateResponse.class);
        return rentalUpdateResponse;
    }

    @Override
    public List<RentalGetResponse> getAll() {
        List<Rental> rentals = rentalRepository.findAll();
        List<RentalGetResponse> rentalGetResponses =
                rentals.stream().map(item -> modelMapper.map(item, RentalGetResponse.class)).toList();
        return rentalGetResponses;
    }

    @Override
    public RentalGetResponse getById(int id) {
        Rental rental = rentalRepository.getReferenceById(id);
        RentalGetResponse getByIdRentalDto = modelMapper.map(rental, RentalGetResponse.class);
        return getByIdRentalDto;
    }
}
