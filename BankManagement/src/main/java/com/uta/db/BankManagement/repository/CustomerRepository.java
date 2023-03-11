package com.uta.db.BankManagement.repository;

import com.uta.db.BankManagement.entity.Account;
import com.uta.db.BankManagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}