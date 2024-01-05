package com.project.customerservice.repositories;


import com.project.customerservice.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer,String> {
    @Override
    List<Customer> findAll();

    Customer getReferenceByUserCode(String userCode);

    Customer findByEmail(String email);

    Customer findByAge (Date birthYear);
}
