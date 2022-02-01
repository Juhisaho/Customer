package com.customer.harjoitus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.customer.harjoitus.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}