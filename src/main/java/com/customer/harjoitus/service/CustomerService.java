package com.customer.harjoitus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.harjoitus.model.Customer;
import com.customer.harjoitus.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getTodos() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    @Override
    public Customer getTodoById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer insert(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void updateTodo(Long id, Customer customer) {
        Customer todoOg = customerRepository.findById(id).get();
//        todoOg.setTodoStatus(todo.getTodoStatus());
        todoOg.setCustomerLastName(customer.getCustomerLastName());
        todoOg.setCustomerFirstName(customer.getCustomerFirstName());
        todoOg.setCustomerAddress(customer.getCustomerAddress());
        todoOg.setCustomerCity(customer.getCustomerCity());
        todoOg.setCustomerPostcode(customer.getCustomerPostcode());
        todoOg.setPhone(customer.getPhone());
        todoOg.setEmail(customer.getEmail());
        customerRepository.save(todoOg);
    }
    
    @Override
    public void deleteTodo(Long id) {
        customerRepository.deleteById(id);
    }

}