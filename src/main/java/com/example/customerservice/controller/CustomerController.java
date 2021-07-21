package com.example.customerservice.controller;

import com.example.customerservice.model.Customer;
import com.example.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerService customerService;
    private Environment environment;
    @Autowired
    public CustomerController(CustomerService customerService, Environment environment) {
        this.customerService = customerService;
        this.environment = environment;
    }
    @GetMapping("/status")
    public ResponseEntity<String> getStatus()
    {
        return ResponseEntity.ok("up and running on port: "+environment.getProperty("local.server.port"));
    }
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer()
    {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customer));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable ("id") Integer id)
    {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable ("id") Integer id,@RequestBody Customer customer)
    {
        return ResponseEntity.ok(customerService.updateCustomer(id,customer));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable ("id") Integer id)
    {
        return ResponseEntity.ok(customerService.DeleteCustomerById(id));
    }
}
