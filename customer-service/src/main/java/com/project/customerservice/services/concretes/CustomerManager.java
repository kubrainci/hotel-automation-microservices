package com.project.customerservice.services.concretes;

import com.project.customerservice.entities.Customer;
import com.project.customerservice.entities.dtos.requests.CustomerAddRequest;
import com.project.customerservice.entities.dtos.responses.CustomerAddResponse;
import com.project.customerservice.entities.dtos.responses.CustomerGetResponse;
import com.project.customerservice.repositories.CustomerRepository;
import com.project.customerservice.services.abstracts.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public void delete(int id) {
       customerRepository.deleteById(id);
    }

    @Override
    public CustomerAddResponse signIn(CustomerAddRequest request) {
        Customer customer=
                Customer.builder()
                        .name(request.getName())
                        .lastName(request.getLastName())
                        .userName(request.getUserName())
                        .email(request.getEmail())
                        .password(request.getPassword())
                        .balance(0)
                        .build();
        customerRepository.save(customer);
        CustomerAddResponse customerAddResponse=
                CustomerAddResponse.builder()
                        .Id(customer.getId())
                        .name(customer.getName())
                        .lastName(customer.getLastName())
                        .userName(customer.getUserName())
                        .build();
        return customerAddResponse ;
    }

    @Override
    public List<CustomerGetResponse> getAll() {
        List<Customer> customers=customerRepository.findAll();
        List<CustomerGetResponse> customerGetResponses= new ArrayList<>();
        CustomerGetResponse customerGetResponse=new CustomerGetResponse();
        for (Customer customer:customers) {
          CustomerGetResponse.builder()
                  .name(customer.getName())
                  .lastName(customer.getLastName())
                  .userName(customer.getUserName())
                  .build();
        }

        return customerGetResponses;
    }
}
