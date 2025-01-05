package com.example.demosoap.repository;

import com.example.demosoap.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {
    CustomerModel findByEmail(String email);
    CustomerModel findByCin(String cin);
}