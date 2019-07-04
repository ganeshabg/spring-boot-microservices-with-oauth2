package com.example.customer.controller;

import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {


    @Autowired
    private CustomerService service;


    @GetMapping(value = "/getCustomers")
    @ResponseBody
    public List<Customer> getAllCustomers(){
        return service.getAllCustomers();
    }

}
