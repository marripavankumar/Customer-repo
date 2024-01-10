package com.example.customer.service;

import com.example.customer.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    List<Customer> getAllCustomers();
}
