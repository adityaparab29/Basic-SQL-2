package com.uta.db.BankManagement.services;

import com.uta.db.BankManagement.entity.*;
import com.uta.db.BankManagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BankManagementServiceImpl implements BankManagementService {

    @Autowired
    BorrowRepository borrowRepository;
    @Autowired
    private BankBranchRepository bankBranchRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CusAccRepository cusAccRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<BankBranch> fetchAllBankBranches() {
        return bankBranchRepository.findAll();
    }

    public List<String> fetchAllBranchNames() {
        return fetchAllBankBranches().stream().map(BankBranch::getBranchName).toList();
    }

    @Override
    public Customer addNewCustomer(Customer customer) {
        Optional<Customer> actual = customerRepository.findById(customer.getSsn());
        if (actual.isPresent()) {
            //throw exception
            System.out.println("Duplicate Customer");
            return customer;
        } else {
            if (customer.getSsn() != null && customer.getName() != null) {
                return customerRepository.save(customer);
            } else {
                return null;
                //throw Exception
            }
        }

    }

    @Override
    public Employee addNewEmployee(Employee employee) {
        if (employee.getSsn() != null && employee.getName() != null && employee.getStartDate() != null) {
            return employeeRepository.save(employee);
        } else {
            return null;
            //throw Exception
        }
    }

    @Override
    public List<Employee> fetchAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Customer> fetchAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public BankBranch addNewBankBranch(BankBranch bankBranch) {
        return bankBranchRepository.save(bankBranch);
    }

    @Override
    public Map<String, Object> fetchCustomerAccount(String customerId) {
        Optional<Customer> actual = customerRepository.findById(customerId);
        Map<String, Object> objectMap = new HashMap<>();
        Customer customer = null;
        if (actual.isPresent()) {
            customer = actual.get();
            List<CusAcc> cusAccs = cusAccRepository.findByCustomer(customer);
            List<Account> accounts = new ArrayList<>();
            for (CusAcc obj : cusAccs) {
                accounts.add(obj.getAccount());
            }
            objectMap.put("customer", customer);
            objectMap.put("listAccount", accounts);
        }
        return objectMap;
    }

    @Override
    public Map<String, Object> fetchCustomerLoan(String customerId) {
        Optional<Customer> actual = customerRepository.findById(customerId);
        Map<String, Object> objectMap = new HashMap<>();
        Customer customer = null;
        if (actual.isPresent()) {
            customer = actual.get();
            List<Borrow> borrowList = borrowRepository.findByCustomer(customer);
            List<LoanDto> loanDtoList = new ArrayList<>();

            if (borrowList != null && borrowList.size() > 0) {
                for (Borrow br : borrowList) {
                    LoanDto dto = new LoanDto();
                    dto.setCustomerId(customerId);
                    dto.setLoanNumber(br.getLoan().getLoanNumber());
                    dto.setAmount(br.getLoan().getAmount());
                    dto.setResidualAmount(br.getLoan().getAmount());
                    dto.setLoanBranch(br.getLoan().getLoanBranch().getBranchName());

                    List<Payment> payments = br.getLoan().getPayment();
                    int count = 0;
                    Double payAmt = 0D;
                    if (payments != null && payments.size() > 0) {
                        for (Payment pay : payments) {
                            count += 1;
                            payAmt += pay.getPaymentAmount();
                        }
                        dto.setPaymentAmount(payAmt);
                        dto.setPaymentsMade(count);
                        dto.setResidualAmount(dto.getAmount() - payAmt);
                    }
                    loanDtoList.add(dto);
                }
            }
            objectMap.put("customer", customer);
            objectMap.put("loanDtoList", loanDtoList);

        }
        return objectMap;
    }

    @Override
    public void addNewAccount(AccountDto accountDto) {
        Optional<Customer> actual = customerRepository.findById(accountDto.getCustomerSSN());
        Customer customer = null;
        if (actual.isPresent()) {
            customer = actual.get();
            Account account = new Account(accountDto);
            BankBranch bankBranch = bankBranchRepository.getById(accountDto.getBankBranch());
            account.setBankBranch(bankBranch);
            account = accountRepository.save(account);

            CusAcc cusAcc = new CusAcc(account, customer, new Date());
            cusAcc = cusAccRepository.save(cusAcc);
        }
    }

}
