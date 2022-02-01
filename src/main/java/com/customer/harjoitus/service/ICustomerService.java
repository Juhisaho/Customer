package com.customer.harjoitus.service;

import java.util.List;

import com.customer.harjoitus.model.Customer;

public interface ICustomerService {
    List<Customer> getTodos();

    Customer getTodoById(Long id);

    Customer insert(Customer customer);

    void updateTodo(Long id, Customer customer);

    void deleteTodo(Long id);
}