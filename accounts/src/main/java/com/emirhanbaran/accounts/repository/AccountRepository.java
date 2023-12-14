package com.emirhanbaran.accounts.repository;

import com.emirhanbaran.accounts.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Long, Account> {
}
