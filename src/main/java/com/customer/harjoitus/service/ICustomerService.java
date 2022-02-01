package com.customer.harjoitus.service;

import java.util.List;

import com.customer.harjoitus.model.Customer;

public interface ICustomerService {
    List<Customer> getCustomers();

    Customer getCustById(Long id);

    Customer insert(Customer customer);

    void updateCust(Long id, Customer customer);

    void deleteCust(Long id);
}