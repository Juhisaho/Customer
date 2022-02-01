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
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    @Override
    public Customer getCustById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer insert(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void updateCust(Long id, Customer customer) {
        Customer customerOg = customerRepository.findById(id).get();
//        todoOg.setTodoStatus(todo.getTodoStatus());
        customerOg.setCustomerLastName(customer.getCustomerLastName());
        customerOg.setCustomerFirstName(customer.getCustomerFirstName());
        customerOg.setCustomerAddress(customer.getCustomerAddress());
        customerOg.setCustomerCity(customer.getCustomerCity());
        customerOg.setCustomerPostcode(customer.getCustomerPostcode());
        customerOg.setPhone(customer.getPhone());
        customerOg.setEmail(customer.getEmail());
        customerRepository.save(customerOg);
    }
    
    @Override
    public void deleteCust(Long id) {
        customerRepository.deleteById(id);
    }

}