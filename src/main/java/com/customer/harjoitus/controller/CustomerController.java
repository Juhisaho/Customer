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
@RequestMapping("api/todo")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllTodos() {
        List<Customer> customers = customerService.getTodos();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Customer> getTodo(@PathVariable Long id) {
        return new ResponseEntity<>(customerService.getTodoById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> saveTodo(@RequestBody Customer customer) {
        Customer todo1 = customerService.insert(customer);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("todo", "/api/todo/" + todo1.getId().toString());
        return new ResponseEntity<>(todo1, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<Customer> updateTodo(@PathVariable("id") Long id, @RequestBody Customer customer) {
        customerService.updateTodo(id, customer);
        return new ResponseEntity<>(customerService.getTodoById(id), HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Customer> deleteTodo(@PathVariable("id") Long id) {
        customerService.deleteTodo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}