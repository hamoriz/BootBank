package com.hamori.controller;

import com.hamori.model.Customer;
import com.hamori.repository.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Zoltan_Hamori
 */

@RestController
@RequestMapping("api/")
public class CustomerController {

    @Autowired
    private CustomerMapper customerMapper;


    @RequestMapping(value = "customers", method = RequestMethod.GET)
    public List<Customer> list() {
        return customerMapper.findAll();
    }

    @RequestMapping(value = "customers/{id}", method = RequestMethod.GET)
    public Customer get(@PathVariable Long id) {
        return customerMapper.findById(id);
    }

    @RequestMapping(value = "customers/name/{name}", method = RequestMethod.GET)
    public Customer get(@PathVariable String name) {
        return customerMapper.findByName(name);
    }

    @RequestMapping(value = "customers", method = RequestMethod.POST)
    public void create(@RequestBody Customer customer) {
        customerMapper.createCustomer(customer);
    }

}
