package com.example.customerservice.service;

import com.example.customerservice.model.Customer;

import java.util.List;

public interface CustomerService {
    public Customer createCustomer(Customer customer);
    public List<Customer> getAllCustomer();
}
