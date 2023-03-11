package com.uta.db.BankManagement.repository;

import com.uta.db.BankManagement.entity.Borrow;
import com.uta.db.BankManagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowRepository extends JpaRepository<Borrow, String> {
    List<Borrow> findByCustomer(Customer customer);
}