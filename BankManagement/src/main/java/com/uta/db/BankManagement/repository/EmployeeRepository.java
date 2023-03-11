package com.uta.db.BankManagement.repository;

import com.uta.db.BankManagement.entity.Account;
import com.uta.db.BankManagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

}