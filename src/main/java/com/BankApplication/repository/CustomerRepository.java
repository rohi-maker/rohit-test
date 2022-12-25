package com.BankApplication.repository;

import com.BankApplication.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public Customer save(Customer customer);
    public List<Customer> findByUsername(String username);
}
