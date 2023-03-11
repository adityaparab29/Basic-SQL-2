package com.uta.db.BankManagement.repository;

import com.uta.db.BankManagement.entity.Loan;
import com.uta.db.BankManagement.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, String> {

}