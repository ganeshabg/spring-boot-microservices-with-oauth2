package com.example.customer.service;


import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {


    @Autowired
    private CustomerRepository repository;

    public List<Customer>  getAllCustomers(){
        return repository.findAll();
    }



}
