package com.project.customerservice.services.abstracts;

import com.project.customerservice.entities.dtos.requests.CustomerAddRequest;
import com.project.customerservice.entities.dtos.requests.CustomerUpdateRequest;
import com.project.customerservice.entities.dtos.responses.CustomerAddResponse;
import com.project.customerservice.entities.dtos.responses.CustomerGetResponse;
import com.project.customerservice.entities.dtos.responses.CustomerUpdateResponse;

import java.util.List;

public interface CustomerService {

    CustomerAddResponse signIn(CustomerAddRequest request);

    List<CustomerGetResponse>getAll();

    CustomerUpdateResponse upDate(String userCode , CustomerUpdateRequest request);

    void delete (String userCode);

    CustomerGetResponse getByUserCode(String userCode);

    double balanceUp(String userCode,double balance);

    double balanceDown(String userCode, double balance);

    double getBalanceByCustomer(String userCode);





}
