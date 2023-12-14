package com.emirhanbaran.accounts.repository;

import com.emirhanbaran.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Long,Customer> {
}
