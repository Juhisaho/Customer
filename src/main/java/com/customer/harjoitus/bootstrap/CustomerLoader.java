package com.customer.harjoitus.bootstrap;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.customer.harjoitus.model.Customer;
import com.customer.harjoitus.service.CustomerService;

@Component
public class CustomerLoader implements CommandLineRunner {

    private final CustomerService customerService;

    @Autowired
    public CustomerLoader(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadTodos();
    }

    private void loadTodos() {
        customerService.insert(
                Customer.builder()
                        .customerFirstName("Juha-Matti")
                        .customerLastName("Aho")
                        .customerAddress("Koroistentie 17")
                        .customerPostcode("00280")
                        .customerCity("Helsinki")
                        .phone("0405306917")
                        .email("ahojuhis@gmail.com")
                        .build()
        );
        customerService.insert(
                Customer.builder()
                        .customerFirstName("Emmi")
                        .customerLastName("Länsman")
                        .customerAddress("Jakomäentie 29")
                        .customerPostcode("00600")
                        .customerCity("Helsinki")
                        .phone("0401234567")
                        .email("emmilansman@gmail.com")
                        .build()
        );
        System.out.println("Sample Todos Loaded.");
    }
}

