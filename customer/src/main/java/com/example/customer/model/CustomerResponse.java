package com.example.customer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CustomerResponse {

    private Customer customer;
    private String  message;

}
