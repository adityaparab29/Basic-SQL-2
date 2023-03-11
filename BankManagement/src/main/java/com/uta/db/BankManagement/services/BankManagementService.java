package com.uta.db.BankManagement.services;

import com.uta.db.BankManagement.entity.AccountDto;
import com.uta.db.BankManagement.entity.BankBranch;
import com.uta.db.BankManagement.entity.Customer;
import com.uta.db.BankManagement.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface BankManagementService {
    List<BankBranch> fetchAllBankBranches();
    Customer addNewCustomer(Customer customer);
    Employee addNewEmployee(Employee employee);

    List<Employee> fetchAllEmployee();

    List<Customer> fetchAllCustomer();
    BankBranch addNewBankBranch(BankBranch bankBranch);


    Map<String, Object> fetchCustomerAccount(String customerId);

    Map<String, Object> fetchCustomerLoan(String customerId);

    void addNewAccount(AccountDto accountDto);
}
