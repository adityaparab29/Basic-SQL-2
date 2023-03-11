package com.uta.db.BankManagement.repository;

import com.uta.db.BankManagement.entity.Account;
import com.uta.db.BankManagement.entity.CusAcc;
import com.uta.db.BankManagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CusAccRepository extends JpaRepository<CusAcc, String> {
    List<CusAcc> findByCustomer(Customer customer);

}