package com.example.customerservice.service;

import com.example.customerservice.dao.CustomerDao;
import com.example.customerservice.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService{
    private CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerDao.save(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerDao.findAll();
    }
}
