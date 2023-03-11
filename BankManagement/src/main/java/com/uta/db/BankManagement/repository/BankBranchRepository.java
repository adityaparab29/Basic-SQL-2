package com.uta.db.BankManagement.repository;

import com.uta.db.BankManagement.entity.BankBranch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankBranchRepository extends JpaRepository<BankBranch, String> {

}