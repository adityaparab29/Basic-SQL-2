package com.uta.db.BankManagement.entity;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ACCOUNT")
public class Account {

    @Id
    @Column(name = "Account_Number")
    private String accountNumber;

    @Column(name = "Balance")
    private Double balance;

    @Column(name = "Account_Type")
    @Enumerated(EnumType.STRING)
    private ACCOUNT_TYPE accountType;

    @Column(name = "Interest_Rate")
    private Double interestRate;

    @Column(name = "Overdraft_Amount")
    private Double overdraftAmount;

    @ManyToOne
    @JoinColumn(name = "Branch_Name")
    private BankBranch bankBranch;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private List<CusAcc> cusAcc;

    public Account() {
    }

    public Account(String accountNumber, Double balance, ACCOUNT_TYPE accountType, Double interestRate, Double overdraftAmount, BankBranch bankBranch) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
        this.interestRate = interestRate;
        this.overdraftAmount = overdraftAmount;
        this.bankBranch = bankBranch;
    }

    private String random() {
        return RandomStringUtils.randomNumeric(12);
    }

    public Account(AccountDto accountDto) {
        this.accountNumber = random();
        this.balance = accountDto.getBalance();
        this.accountType = accountDto.getAccountType();
        this.interestRate = RandomUtils.nextDouble(1.0d, 12.0d);
        this.overdraftAmount = 0d;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public ACCOUNT_TYPE getAccountType() {
        return accountType;
    }

    public void setAccountType(ACCOUNT_TYPE accountType) {
        this.accountType = accountType;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Double getOverdraftAmount() {
        return overdraftAmount;
    }

    public void setOverdraftAmount(Double overdraftAmount) {
        this.overdraftAmount = overdraftAmount;
    }

    public BankBranch getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(BankBranch bankBranch) {
        this.bankBranch = bankBranch;
    }

    public List<CusAcc> getCusAcc() {
        return cusAcc;
    }

    public void setCusAcc(List<CusAcc> cusAcc) {
        this.cusAcc = cusAcc;
    }
}
