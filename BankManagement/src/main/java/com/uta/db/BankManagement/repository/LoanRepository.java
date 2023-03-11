package com.uta.db.BankManagement.repository;

import com.uta.db.BankManagement.entity.Account;
import com.uta.db.BankManagement.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, String> {

}