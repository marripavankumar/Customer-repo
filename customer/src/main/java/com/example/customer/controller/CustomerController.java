package com.example.customer.controller;

import com.example.customer.model.Customer;
import com.example.customer.model.CustomerResponse;
import com.example.customer.service.CustomerService;
import com.example.customer.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<CustomerResponse> save(@RequestBody  Customer customer){
        if (null == customer) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new CustomerResponse(null, Constants.BAD_REQUEST));
        }
        if (null != customer.getDob() && customer.getDob().isAfter(LocalDateTime.now())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new CustomerResponse(null, Constants.INVALID_DOB));
        }
        customerService.saveCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CustomerResponse(customer,Constants.CUSTOMER_SUCCESS));

    }


    @GetMapping("/list")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
}
