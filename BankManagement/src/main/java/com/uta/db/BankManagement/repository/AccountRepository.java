package com.uta.db.BankManagement.repository;

import com.uta.db.BankManagement.entity.Account;
import com.uta.db.BankManagement.entity.BankBranch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {

}