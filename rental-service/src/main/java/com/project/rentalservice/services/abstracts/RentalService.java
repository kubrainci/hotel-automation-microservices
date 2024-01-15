package com.project.rentalservice.services.abstracts;

import com.project.rentalservice.entities.dtos.requests.RentalUpdateRequest;
import com.project.rentalservice.entities.dtos.requests.SubmitRentalDto;
import com.project.rentalservice.entities.dtos.responses.RentalGetResponse;
import com.project.rentalservice.entities.dtos.responses.RentalUpdateResponse;

import java.util.List;

public interface RentalService {

    String submitRental(SubmitRentalDto submitRentalDto);

    void delete(int id);

    RentalUpdateResponse upDate(int id ,RentalUpdateRequest request );

    List<RentalGetResponse> getAll();

    RentalGetResponse getById(int id);
}
