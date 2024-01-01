package com.project.customerservice.services.abstracts;

import com.project.customerservice.entities.dtos.requests.CustomerAddRequest;
import com.project.customerservice.entities.dtos.responses.CustomerAddResponse;
import com.project.customerservice.entities.dtos.responses.CustomerGetResponse;

import java.util.List;

public interface CustomerService {

    void delete (int id);

    CustomerAddResponse signIn(CustomerAddRequest request);

    List<CustomerGetResponse>getAll();
}
