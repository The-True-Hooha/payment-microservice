package com.github.TheTrueHooha.CustomerService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void saveCustomerDetails(CustomerRequest customerRequest){
        CustomerModel customerModel = CustomerModel.builder()
                .customerName(customerRequest.customerName())
                .customerAddress(customerRequest.customerAddress())
                .customerPhoneNumber(customerRequest.customerPhoneNumber())
                .build();
         customerRepository.save(customerModel);

    }
}
