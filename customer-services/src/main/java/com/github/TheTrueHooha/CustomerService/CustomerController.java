package com.github.TheTrueHooha.CustomerService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/new")
    public void AddNewCustomer(@RequestBody CustomerRequest customerRequest){
        log.info("adding new customer{}", customerRequest);
        customerService.saveCustomerDetails(customerRequest);
    }
}
