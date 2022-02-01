package com.customer.harjoitus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.customer.harjoitus.model.Customer;
import com.customer.harjoitus.service.CustomerService;

import java.util.List;


@RestController
@RequestMapping("api/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCust() {
        List<Customer> customers = customerService.getCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Customer> getCust(@PathVariable Long id) {
        return new ResponseEntity<>(customerService.getCustById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> saveCust(@RequestBody Customer customer) {
        Customer cust1 = customerService.insert(customer);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("customer", "/api/customer/" + cust1.getId().toString());
        return new ResponseEntity<>(cust1, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<Customer> updateCust(@PathVariable("id") Long id, @RequestBody Customer customer) {
        customerService.updateCust(id, customer);
        return new ResponseEntity<>(customerService.getCustById(id), HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Customer> deleteCust(@PathVariable("id") Long id) {
        customerService.deleteCust(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
   

}