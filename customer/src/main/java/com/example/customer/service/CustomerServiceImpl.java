package com.example.customer.service;

import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private  CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {

        customerRepository.saveAndFlush(customer);
        return customer;

    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
