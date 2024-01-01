package com.project.customerservice.repositories;


import com.project.customerservice.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer,Integer> {
    @Override
    List<Customer> findAll();
}
