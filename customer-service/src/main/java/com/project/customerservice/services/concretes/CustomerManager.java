package com.project.customerservice.services.concretes;

import com.project.customerservice.core.exceptions.BusinessException;
import com.project.customerservice.entities.Customer;
import com.project.customerservice.entities.dtos.requests.CustomerAddRequest;
import com.project.customerservice.entities.dtos.requests.CustomerUpdateRequest;
import com.project.customerservice.entities.dtos.responses.CustomerAddResponse;
import com.project.customerservice.entities.dtos.responses.CustomerGetResponse;
import com.project.customerservice.entities.dtos.responses.CustomerUpdateResponse;
import com.project.customerservice.repositories.CustomerRepository;
import com.project.customerservice.services.abstracts.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final MessageSource messageSource;


    @Override
    public CustomerAddResponse signIn(CustomerAddRequest request) {
        customerWithSameEmailShouldNotExist(request.getEmail());

        Customer customerForAutoMapping = modelMapper.map(request, Customer.class);
        customerForAutoMapping = customerRepository.save(customerForAutoMapping);
        CustomerAddResponse customerAddResponse =
                modelMapper.map(customerForAutoMapping, CustomerAddResponse.class);

//        Customer customer=
//                Customer.builder()
//                        .birthYear(request.getBirthYear())
//                        .name(request.getName())
//                        .lastName(request.getLastName())
//                        .userName(request.getUserName())
//                        .email(request.getEmail())
//                        .password(request.getPassword())
//                        .balance(0)
//                        .build();
//        customerRepository.save(customer);
//        CustomerAddResponse customerAddResponse=
//                CustomerAddResponse.builder()
//                        .Id(customer.getId())
//                        .name(customer.getName())
//                        .lastName(customer.getLastName())
//                        .userName(customer.getUserName())
//                        .build();
        return customerAddResponse ;
    }


    @Override
    public List<CustomerGetResponse> getAll() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerGetResponse> customerGetResponses =
                customers.stream().map(item -> modelMapper.map(item, CustomerGetResponse.class)).toList();

//        List<Customer> customers=customerRepository.findAll();
//        List<CustomerGetResponse> customerGetResponses= new ArrayList<>();
//        CustomerGetResponse customerGetResponse=new CustomerGetResponse();
//        for (Customer customer:customers) {
//          CustomerGetResponse.builder()
//                  .name(customer.getName())
//                  .lastName(customer.getLastName())
//                  .userName(customer.getUserName())
//                  .build();
//        }

        return customerGetResponses;
    }

    @Override
    public void delete(String userCode) {

        customerRepository.deleteById(userCode);
    }

    @Override
    public CustomerUpdateResponse upDate(String userCode, CustomerUpdateRequest request) {
        Customer customer = customerRepository.getReferenceByUserCode(userCode);
        modelMapper.map(request, customer);
        customer = customerRepository.save(customer);

        CustomerUpdateResponse customerUpdateResponse =
                modelMapper.map(customer, CustomerUpdateResponse.class);
        return customerUpdateResponse;
    }

    @Override
    public CustomerGetResponse getByUserCode(String userCode) {
        Customer customer = customerRepository.getReferenceByUserCode(userCode);
        modelMapper.map(userCode, customer);
        customer = customerRepository.save(customer);

       CustomerGetResponse customerGetResponse =
                modelMapper.map(customer, CustomerGetResponse.class);
        return customerGetResponse;
    }

    @Override
    public double balanceUp(String userCode, double balance) {
        Customer customer = customerRepository.getReferenceByUserCode(userCode);
        customer.setBalance(customer.getBalance() + balance);
        customer = customerRepository.save(customer);
        return customer.getBalance();
    }

    @Override
    public double balanceDown(String userCode, double balance) {
        Customer customer = customerRepository.getReferenceByUserCode(userCode);
        customer.setBalance(customer.getBalance() - balance);
        customer = customerRepository.save(customer);

        return customer.getBalance();
    }

    @Override
    public double getBalanceByCustomer(String userCode) {
        Customer customer = customerRepository.getReferenceByUserCode(userCode);
        modelMapper.map(userCode, customer);
        customer = customerRepository.save(customer);

        CustomerGetResponse customerGetResponse =
                modelMapper.map(customer, CustomerGetResponse.class);
        return customer.getBalance();
    }


    private void customerWithSameEmailShouldNotExist(String email) {
        Customer customerWithSameEmail = customerRepository.findByEmail(email);
        if (customerWithSameEmail != null) {
            // Business kuralı hatası
            throw new BusinessException(
                    messageSource.getMessage(
                            "customerWithSameEmailShouldNotExist", null, LocaleContextHolder.getLocale()));
        }
    }



}
